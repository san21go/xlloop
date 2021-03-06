package org.boris.expr.function.excel;

import org.boris.expr.Expr;
import org.boris.expr.ExprError;
import org.boris.expr.ExprException;
import org.boris.expr.ExprInteger;
import org.boris.expr.function.AbstractFunction;

public class SEARCH extends AbstractFunction
{
    public Expr evaluate(Expr[] args) throws ExprException {
        assertMinArgCount(args, 2);
        assertMaxArgCount(args, 3);

        String f = asString(args[0], true).toLowerCase();
        String s = asString(args[1], true).toLowerCase();
        int pos = 0;
        if (args.length == 3)
            pos = asInteger(args[2], true);

        int i = s.indexOf(f, pos);
        if (i == -1)
            return ExprError.VALUE;

        return new ExprInteger(i + 1);
    }
}
