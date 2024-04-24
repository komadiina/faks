package net.etfbl.collections;

import java.util.Collection;
import java.util.Iterator;

public class Remover {
	void filter(Collection<?> c) {
		for (Iterator<?> it = c.iterator(); it.hasNext(); )
//			if (!cond(it.next()))
			 it.remove();
	}

}
