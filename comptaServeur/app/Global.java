import models.SpendingNature;
import play.Application;
import play.GlobalSettings;
import play.libs.Yaml;

import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings
{
	public void onStart(Application app)
	{
		System.out.println("Starting CompatServeur");
		if(SpendingNature.all().size() == 0)
		{
			System.out.println("Creates initial data");
			Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
            System.out.println(all.get("natures").size() + "natures prédéfinies");
			Ebean.save(all.get("natures"));
		}
	}
}
