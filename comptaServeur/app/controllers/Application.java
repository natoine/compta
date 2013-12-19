package controllers;

import java.util.List;

import models.FinancialOperation;
import models.Income;
import models.Spending;
import models.SpendingNature;
import play.data.Form;
import play.mvc.*;
import play.mvc.Http.RequestBody;
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
    	RequestBody body = request().body();
    	//Spending spending = spendingForm.bindFromRequest().get();
    	Spending spending = new Spending();
    	spending.setAmount(Float.parseFloat(body.asFormUrlEncoded().get("amount")[0]));
    	spending.setDescription(body.asFormUrlEncoded().get("description")[0]);
    	spending.setLabel(body.asFormUrlEncoded().get("label")[0]);
    	spending.setNature(SpendingNature.findById(body.asFormUrlEncoded().get("nature")[0]));
    	Spending.create(spending);
    	return ok();
    }
    
    public static Result submitIncome()
    {
    	RequestBody body = request().body();
    	//Income income = incomeForm.bindFromRequest().get();
    	Income income = new Income();
    	income.setAmount(Float.parseFloat(body.asFormUrlEncoded().get("amount")[0]));
    	income.setDescription(body.asFormUrlEncoded().get("description")[0]);
    	income.setLabel(body.asFormUrlEncoded().get("label")[0]);
    	Income.create(income);
    	return ok();
    }
}
