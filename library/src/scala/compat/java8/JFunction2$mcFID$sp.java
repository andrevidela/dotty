
/*
 * Copyright (C) 2012-2014 Typesafe Inc. <http://www.typesafe.com>
 */

package scala.compat.java8;

@FunctionalInterface
public interface JFunction2$mcFID$sp extends JFunction2 {
    abstract float apply$mcFID$sp(int v1, double v2);

    default Object apply(Object v1, Object v2) { return (Float) apply$mcFID$sp(scala.runtime.BoxesRunTime.unboxToInt(v1), scala.runtime.BoxesRunTime.unboxToDouble(v2)); }
}
