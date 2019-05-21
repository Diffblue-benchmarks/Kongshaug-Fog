/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentaionLayer;

import DataLayer.DataException;
import FunctionLayer.FunctionManager;
import FunctionLayer.HelpingClasses.Carport;
import FunctionLayer.HelpingClasses.Order;
import FunctionLayer.HelpingClasses.Roof;
import FunctionLayer.HelpingClasses.RoofType;
import FunctionLayer.HelpingClasses.Shed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sofieamalielandt
 */
public class UpdateCarportCommand implements Command
{
    private String target;

    public UpdateCarportCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, FunctionManager manager) throws CommandException, DataException
    {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        
        String rooftype = request.getParameter("roof");
        String typeId = request.getParameter("type");
        String slope_str = request.getParameter("slope");
        int slope;

        int depth = Integer.parseInt(request.getParameter("depth"));
        int width = Integer.parseInt(request.getParameter("width"));

        int shedDepth = Integer.parseInt(request.getParameter("shedDepth"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        String shedOrNot = request.getParameter("shed");

        if (typeId == null)
        {
            request.setAttribute("errormessage", "Vælg venligst tagtype!");
            return target;
        }
        if (rooftype.equals("sloped") && slope_str.equals("0"))
        {
            request.setAttribute("errormessage", "Vælg venligst hældning!");
            return target;
        }

        if ("Med skur".equals(shedOrNot))
        {
            if (shedDepth > depth - 30 || shedWidth > width - 30)
            {
                request.setAttribute("errormessage", "Skuret skal være mindst 30 cm smallere og kortere end carporten. "
                        + "Målene for dit skur er lige nu  " + (shedDepth - (depth - 30)) + " for dybe og " + (shedWidth - (width - 30)) + " for bred. Prøv igen.");

                return target;
            }
        }

        if (depth != 0 && width != 0)
        {
            RoofType type = manager.getRoofTypeById(Integer.parseInt(typeId));

            if ("Uden skur".equals(shedOrNot))
            {
                shedDepth = 0;
                shedWidth = 0;
            }
            if (slope_str == null)
            {
                slope = 0;

            } else
            {
                slope = Integer.parseInt(slope_str);
            }
            
            String res = manager.updateCarport(order.getCarport(), depth, width, type, slope, shedWidth, shedDepth);
            order.calcSalesPrice();
            request.setAttribute("errormessage", res);
            session.setAttribute("order", order);

            return target;

        } else
        {
            request.setAttribute("errormessage", "Vælg venligst dybte og bredde på carporten!");
            return target;
        }
    }
}
