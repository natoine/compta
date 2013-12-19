package models;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class SpendingNature extends Model
{
	@Id
	public long id ;
	
	public String label ;
	
	//Finder
		public static Finder<Long, SpendingNature> find = new Finder<Long, SpendingNature>(Long.class, SpendingNature.class);

		//Constructeur
		public SpendingNature()
		{
		}

		//Options
		public static Map<String,String> options() 
		{
			List<SpendingNature> natures = all();
			LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
			for(SpendingNature nature: natures) {
				options.put("" + nature.id, nature.label);
			}
			return options;
		}
		
		//Persistance

		/**
		 * Renvoie la liste de tous les SpendingNatures enregistrés
		 * @return
		 */
		public static List<SpendingNature> all()
		{
			return find.all();
		}

		/**
		 * Enregistre en base de données le SpendingNature passé en paramètre
		 * @param game
		 */
		public static void create(SpendingNature SpendingNature)
		{
			Ebean.save(SpendingNature);
		}

		/**
		 * Met à jour dans la BDD le SpendingNature passé en paramètre
		 * @param game
		 */
		public static void update(SpendingNature SpendingNature)
		{
			Ebean.save(SpendingNature);
		}

		/**
		 * Récupère dans la BDD le SpendingNature dont l'identifiant a été passé en paramètre
		 * @param id
		 * @return
		 */
		public static SpendingNature findById(String id)
		{
			return findById(Long.parseLong(id));
		}

		/**
		 * Récupère dans la BDD le SpendingNature dont l'identifiant a été passé en paramètre
		 * @param id
		 * @return
		 */
		public static SpendingNature findById(Long id)
		{
			return find.byId(id);
		}

		//Accesseurs

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public long getId() {
			return id;
		}		
}
