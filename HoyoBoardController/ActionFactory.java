package HoyoBoardController;

import HoyoBoardAction.*;

public class ActionFactory {
	
	private ActionFactory() {
		super();
	}
	
	private static ActionFactory instance=new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action=null;
		System.out.println("서블릿에서 받은 command : "+command);
		
		if(command.equals("hoyoboard_list")) {
			action=new HoyoBoardListAction();
		}else if(command.equals("hoyoboard_write_form")) {
			action=new HoyoBoardWriteFormAction();
		}else if(command.equals("hoyoboard_write")) {
			action=new HoyoBoardWriteAction();
		}else if(command.equals("hoyoboard_view")) {
			action=new HoyoBoardViewAction();
		}else if(command.equals("hoyoboard_check_pass_form")) {
			action=new HoyoBoardCheckPassFormAction();
		}else if(command.equals("hoyoboard_check_pass")) {
			action=new HoyoBoardCheckPassAction();
		}else if(command.equals("hoyoboard_update_form")) {
			action=new HoyoboardUpdateFormAction();
		}else if(command.equals("hoyoboard_update")) {
			action=new HoyoboardUpdateAction();
		}else if(command.equals("hoyoboard_delete")) {
			action=new HoyoboardDeleteAction();
		}else if(command.equals("hoyoboard_search")) {
			action=new HoyoboardSearchAction();
		}
		
		return action;
	}
}
