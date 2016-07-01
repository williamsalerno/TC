package br.com.timetrialfactory.utils;

import static java.util.UUID.randomUUID;

public class LicenseGenerator {

	private LicenseGenerator() {
	}

	public static String generateCode() {
		return randomUUID().toString();
	}

}
