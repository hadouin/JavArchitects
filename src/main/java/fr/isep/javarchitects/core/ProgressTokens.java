package fr.isep.javarchitects.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProgressTokens {

	public static final List<ProgressToken> TOKENS = Collections.unmodifiableList(createTokenList());
	
	// there is 1 token of each type, and 2 tokens of the same 'Culture' type
	private static List<ProgressToken> createTokenList() {
		List<ProgressToken> res = new ArrayList<ProgressToken>();
		res.addAll(Arrays.asList(ProgressToken.values()));
		res.add(ProgressToken.Culture);
		return res;
	}

}
