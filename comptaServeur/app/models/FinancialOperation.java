package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.avaje.ebean.Ebean;

@Entity
public abstract class FinancialOperation extends Model
{

	//Attributs Persistants

	@Id
	public long id;

	//Date ou l'opération est prévue
	public Date expectedDate ;
	//Date ou l'opération est effectuée. Si non effectuée, elle est prévue.
	public Date effectiveDate ;
	//Date ou l'opération est déclarée dans l'application
	public Date declarativeDate ;

	public String label ;

	public String description ;

	//Finder
	public static Finder<Long, FinancialOperation> find = new Finder<Long, FinancialOperation>(Long.class, FinancialOperation.class);

	//Constructeur
	public FinancialOperation()
	{
	}

	//Etat
	/**
	 * Tells if a FinancialOperation is already done or not. If it is already done, it is an effective FinancialOperation.
	 * @return
	 */
	public boolean isEffective()
	{
		if(effectiveDate == null) return false ;
		return true ;
	}

	//Persistance

	/**
	 * Renvoie la liste de tous les FinancialOperations enregistrés
	 * @return
	 */
	public static List<FinancialOperation> all()
	{
		return find.all();
	}

	/**
	 * Enregistre en base de données le FinancialOperation passé en paramètre
	 * @param game
	 */
	public static void create(FinancialOperation FinancialOperation)
	{
		FinancialOperation.declarativeDate = new Date();
		Ebean.save(FinancialOperation);
	}

	/**
	 * Met à jour dans la BDD le FinancialOperation passé en paramètre
	 * @param game
	 */
	public static void update(FinancialOperation FinancialOperation)
	{
		Ebean.save(FinancialOperation);
	}

	/**
	 * Récupère dans la BDD le FinancialOperation dont l'identifiant a été passé en paramètre
	 * @param id
	 * @return
	 */
	public static FinancialOperation findById(String id)
	{
		return findById(Long.parseLong(id));
	}

	/**
	 * Récupère dans la BDD le FinancialOperation dont l'identifiant a été passé en paramètre
	 * @param id
	 * @return
	 */
	public static FinancialOperation findById(Long id)
	{
		return find.byId(id);
	}

	//Accesseurs

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getDeclarativeDate() {
		return declarativeDate;
	}

	public void setDeclarativeDate(Date declarativeDate) {
		this.declarativeDate = declarativeDate;
	}

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

	public static Finder<Long, FinancialOperation> getFind() {
		return find;
	}

	public static void setFind(Finder<Long, FinancialOperation> find) {
		FinancialOperation.find = find;
	}

	public long getId() {
		return id;
	}
}