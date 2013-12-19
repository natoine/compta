package models;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;

@Entity
public class Project extends Model
{
	//Attributs

	@Id
	public long id ;

	public String label ;
	public String description ;
	public Date creation ;

	//Finder
	public static Finder<Long, Project> find = new Finder<Long, Project>(Long.class, Project.class);

	//Constructeur
	public Project()
	{
	}

	//Options
	public static Map<String,String> options() 
	{
		List<Project> projects = all();
		LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
		for(Project project: projects) {
			options.put("" + project.id, project.label);
		}
		return options;
	}

	//Persistance

	/**
	 * Renvoie la liste de tous les Projects enregistrés
	 * @return
	 */
	public static List<Project> all()
	{
		return find.all();
	}

	/**
	 * Enregistre en base de données le Project passé en paramètre
	 * @param game
	 */
	public static void create(Project Project)
	{
		Project.creation = new Date();
		Ebean.save(Project);
	}

	/**
	 * Met à jour dans la BDD le Project passé en paramètre
	 * @param game
	 */
	public static void update(Project Project)
	{
		Ebean.save(Project);
	}

	/**
	 * Récupère dans la BDD le Project dont l'identifiant a été passé en paramètre
	 * @param id
	 * @return
	 */
	public static Project findById(String id)
	{
		return findById(Long.parseLong(id));
	}

	/**
	 * Récupère dans la BDD le Project dont l'identifiant a été passé en paramètre
	 * @param id
	 * @return
	 */
	public static Project findById(Long id)
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public long getId() {
		return id;
	}
}
