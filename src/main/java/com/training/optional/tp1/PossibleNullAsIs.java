package com.training.optional.tp1;

import java.util.Optional;

public class PossibleNullAsIs {

//	Le programme PossibleNullAsIs, affiche le nom de rue d’une entreprise
//	On souhaite rendre la donnée nom de rue Optionnelle en utilisant l’API Optional
//	Modifier la classe Address, en passant par le mot clé Optional
//	Adapter la classe PossibleNullAsIs , pour gérer le cas où le nom de rue n’est pas renseigné

	public static void main(String[] args) {
		Address address = new Address(null, "New York");
		Office office = new Office("OF1", address);
		Company company = new Company("Door Never Closed", office);

		final Optional<String> mayBeStreet = getStreet(company);
		System.out.println("Street Name:" + mayBeStreet.orElse("none"));
	}

	private static Optional<String> getStreet(Company company) {
		Optional<String> streetAddress = Optional.empty();
		if (company != null) {
			Office office = company.getOffice();
			if (office != null) {
				Address address = office.getAddress();
				if (address != null) {
					streetAddress = address.getStreet();
				}
			}
		}
		return streetAddress;
	}
}
