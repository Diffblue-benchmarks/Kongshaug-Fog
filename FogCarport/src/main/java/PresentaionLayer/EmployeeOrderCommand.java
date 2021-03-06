/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentaionLayer;

import DataLayer.DataException;
import FunctionLayer.Enum.Role;
import FunctionLayer.FunctionManager;
import FunctionLayer.HelpingClasses.Order;
import FunctionLayer.HelpingClasses.RoofType;
import FunctionLayer.HelpingClasses.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class EmployeeOrderCommand implements Command
{
    private String target;
    private String denied;

    public EmployeeOrderCommand(String target, String denied)
    {
        this.target = target;
        this.denied = denied;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int order_id = Integer.parseInt(request.getParameter("selected"));
        Order order = manager.getOrder(order_id);

        if (user.getRole().equals(Role.EMPLOYEE) || user.getRole().equals(Role.ADMIN))
        {
            if (order.getCarport().getShed() != null)
            {
                manager.calcShed(order.getCarport());
            }

            manager.calcCarport(order.getCarport());
            manager.calcRoof(order.getCarport());
            session.setAttribute("order", order);

            List<RoofType> slopedRoofs = manager.getSlopedRoofs();
            List<RoofType> flatRoofs = manager.getFlatRoofs();
            session.setAttribute("slopedroofs", slopedRoofs);
            session.setAttribute("flatroofs", flatRoofs);

            return target;
        } else
        {
            request.setAttribute("message", "Adgang nægtet");
            return denied;
        }
    }
}
