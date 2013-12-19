package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Spending extends FinancialOperation
{
	//Attributs
	
	//permet de préciser le type de dépense, si c'est du matériel de bureau, des frais de déplacement ...
	@ManyToOne
	public SpendingNature nature ;
	
	//Finder
	public static Finder<Long, Spending> find = new Finder<Long, Spending>(Long.class, Spending.class);

	//Constructeur
	public Spending()
	{
	}

	//Persistance

	/**
	 * Renvoie la liste de tous les Spending enregistrés
	 * @return
	 */
	public static List<Spending> allSpending()
	{
		return find.all();
	}
	
	//Accesseurs Customs
	
	public String getNatureName()
	{
		return nature.getLabel();
	}

	//Accesseurs
	
	public SpendingNature getNature() {
		return nature;
	}

	public void setNature(SpendingNature nature) {
		this.nature = nature;
	}
}