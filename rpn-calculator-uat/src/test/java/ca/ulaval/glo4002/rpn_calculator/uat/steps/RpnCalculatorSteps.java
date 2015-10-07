package ca.ulaval.glo4002.rpn_calculator.uat.steps;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;

import ca.ulaval.glo4002.rpn_calculator.uat.hooks.JettyStarterHook;
import cucumber.api.java.Before;
import cucumber.api.java8.Fr;

public class RpnCalculatorSteps implements Fr {

    private static final String EQUATION_PARAMETER = "equation";

    private static final String VALID_EQUATION = "1 2 +";
    private static final Integer VALID_EQUATION_ANSWER = 3;
    private static final String INVALID_EQUATION = "1 2 + 1";

    private static final int[] NUMBERS_TO_SUM = new int[]{1, 2, 3, 10};
    private static final int NUMBERS_TO_SUM_ANSWER = 16;

    private Response response;

    @Before
    public void clearResponse() {
        response = null;
    }

    public RpnCalculatorSteps() {
        Quand("j'écris un calcul valide", () -> {
            calculate(VALID_EQUATION);
        });

        Quand("j'écris un calcul invalide", () -> {
            calculate(INVALID_EQUATION);
        });

        Quand("j'écris une liste de nombres à additionner", () -> {
            response = given().port(JettyStarterHook.JETTY_TEST_PORT).header(new Header("content-type", MediaType.APPLICATION_JSON))
                    .body(NUMBERS_TO_SUM).when().post("/rpn/sum");
        });

        Alors("la calculatrice me retourne la réponse", () -> {
            response.then().statusCode(Status.OK.getStatusCode()).body("result", equalTo(VALID_EQUATION_ANSWER));
        });

        Alors("la calculatrice me retourne une erreur", () -> {
            response.then().statusCode(Status.BAD_REQUEST.getStatusCode()).body(not(isEmptyOrNullString()));
        });

        Alors("la calculatrice me retourne la somme", () -> {
            response.then().statusCode(Status.OK.getStatusCode()).body("result", equalTo(NUMBERS_TO_SUM_ANSWER));
        });
    }

    private void calculate(String equation) {
        response = given().port(JettyStarterHook.JETTY_TEST_PORT).parameters(EQUATION_PARAMETER, equation).when().get("/rpn/result");
    }

}
