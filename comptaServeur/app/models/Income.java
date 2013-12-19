package models;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn( name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("income")
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