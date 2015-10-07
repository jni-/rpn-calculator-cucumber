package ca.ulaval.glo4002.rpn_calculator.interfaces.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ca.ulaval.glo4002.rpn_calculator.domain.InvalidOperatorException;
import ca.ulaval.glo4002.rpn_calculator.domain.RpnCalculator;
import ca.ulaval.glo4002.rpn_calculator.domain.UnbalancedEquationException;
import ca.ulaval.glo4002.rpn_calculator.services.CalculationResult;
import ca.ulaval.glo4002.rpn_calculator.services.CalculatorService;

@Path("/rpn")
@Produces(MediaType.APPLICATION_JSON)
public class RpnResource {

    private CalculatorService service;

    public RpnResource() {
        service = new CalculatorService(new RpnCalculator());
    }

    @GET
    @Path("/result")
    public Response calculate(@QueryParam("equation") String equation) {
        try {
            CalculationResult result = service.calculateRpn(equation);
            return Response.ok(result).build();
        } catch (UnbalancedEquationException | InvalidOperatorException e) {
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/sum")
    public Response sum(List<Integer> numbers) {
        CalculationResult result = service.sum(numbers);
        return Response.ok(result).build();
    }

}
