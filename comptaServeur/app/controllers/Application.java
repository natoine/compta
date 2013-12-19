package controllers;

import java.util.List;

import models.FinancialOperation;
import models.Income;
import models.Spending;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	static Form<Spending> spendingForm = Form.form(Spending.class);
	static Form<Income> incomeForm = Form.form(Income.class);
	
    public static Result index() 
    {
    	List<FinancialOperation> operations = FinancialOperation.all();
        return ok(index.render(operations, spendingForm, incomeForm));
    }

    public static Result submitSpending()
    {
    	System.out.println("submitSpending body : " + request().body());
    	return ok();
    }
    
    public static Result submitIncome()
    {
    	System.out.println("submitIncome body : " + request().body());
    	return ok();
    }
}
