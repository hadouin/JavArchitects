package fr.isep.javarchitects.model;

import fr.isep.javarchitects.utils.images.Icons;

public enum ScienceCategory {

	Law(Icons.LAW),
	Mechanic(Icons.MECHANIC),
	Architect(Icons.ARCHITECT);

	public Icons icon;

	ScienceCategory(Icons icon)  {
		this.icon = icon;
	}
}
