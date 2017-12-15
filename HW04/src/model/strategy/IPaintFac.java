package model.strategy;

/** 
 * the factory that makes a paint strategy at a time
 * @author Yiqing Lu
 * @author Ye Wang
 */

import model.strategy.IPaintStrategy;

public abstract class IPaintFac {
	public abstract IPaintStrategy make();
}
