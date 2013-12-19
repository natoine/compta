package models;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Spending extends FinancialOperation
{
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
}