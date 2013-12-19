package controllers;

import java.util.List;

import models.FinancialOperation;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() 
    {
    	List<FinancialOperation> operations = FinancialOperation.all();
        return ok(index.render(operations));
    }

}
