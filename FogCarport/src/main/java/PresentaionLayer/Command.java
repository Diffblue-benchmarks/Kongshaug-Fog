package PresentaionLayer;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
  //      commands.put( "login", new CMD_Login() );

    }

//    static Command from( HttpServletRequest request ) {
//        String commandName = request.getParameter( "command" );
//        if ( commands == null ) {
//            initCommands();
//        }
//        return commands.getOrDefault(commandName, new CMD_UnknownCommand() );
//        
//    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws Exception;

}
