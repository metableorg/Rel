package ca.mb.armchair.rel3.storage.catalog;

import ca.mb.armchair.rel3.storage.RelDatabase;
import ca.mb.armchair.rel3.storage.relvars.RelvarGlobal;
import ca.mb.armchair.rel3.storage.relvars.RelvarHeading;
import ca.mb.armchair.rel3.storage.relvars.RelvarMetadata;
import ca.mb.armchair.rel3.types.*;
import ca.mb.armchair.rel3.types.builtin.TypeCharacter;
import ca.mb.armchair.rel3.types.builtin.TypeInteger;
import ca.mb.armchair.rel3.generator.SelectAttributes;
import ca.mb.armchair.rel3.exceptions.ExceptionSemantic;

public class RelvarVersionMetadata extends RelvarMetadata {
	public static final long serialVersionUID = 0;
	
	static Heading getNewHeading() {
		Heading heading = new Heading();
		heading.add("minor", TypeInteger.getInstance());
		heading.add("major", TypeInteger.getInstance());
		heading.add("revision", TypeInteger.getInstance());
		heading.add("copyright", TypeCharacter.getInstance());
		heading.add("license", TypeCharacter.getInstance());
		heading.add("versionnum", TypeCharacter.getInstance());
		heading.add("redistribution", TypeCharacter.getInstance());
		heading.add("release", TypeCharacter.getInstance());
		heading.add("versionstr", TypeCharacter.getInstance());
		heading.add("warranty", TypeCharacter.getInstance());
		return heading;
	}
	
	static RelvarHeading getNewKeyDefinition() {
		RelvarHeading keydef = new RelvarHeading(getNewHeading());
		keydef.addKey(new SelectAttributes());
		return keydef;
	}
	
	public RelvarVersionMetadata(RelDatabase database) {
		super(database, getNewKeyDefinition(), RelDatabase.systemOwner);
	}
	
	public RelvarGlobal getRelvar(String name, RelDatabase database) {
		return new RelvarVersion(database);
	}

	public void dropRelvar(RelDatabase database) {
		throw new ExceptionSemantic("RS0206: The " + Catalog.relvarVersion + " relvar may not be dropped.");		
	}
}
