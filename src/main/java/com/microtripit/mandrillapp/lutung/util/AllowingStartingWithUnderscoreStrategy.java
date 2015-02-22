package com.microtripit.mandrillapp.lutung.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;

/**
 * This class allows a field to have an underscore at the beggining, i.e. _id
 * 
 * @author nando.elance@gmail.com
 */
public class AllowingStartingWithUnderscoreStrategy extends LowerCaseWithUnderscoresStrategy {

	private static final long serialVersionUID = 8910424345561683814L;

	@Override
	public String translate(String input) {
		if (input == null) {
			return input; // garbage in, garbage out
		}
		String output = super.translate(input);
		if (input.startsWith("_")){
			output = "_"+output;
		}
		return output;
	}
}

