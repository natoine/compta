package models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Income extends FinancialOperation
{
	//Finder
	public static Finder<Long, Income> find = new Finder<Long, Income>(Long.class, Income.class);

	//Constructeur
	public Income()
	{
	}

	//Persistance

	/**
	 * Renvoie la liste de tous les Income enregistrés
	 * @return
	 */
	public static List<Income> allIncome()
	{
		return find.all();
	}
}