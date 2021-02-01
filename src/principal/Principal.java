package principal;

import java.awt.EventQueue;

import visao.JanelaMenuPrincipal;

public class Principal {

    public static void main(String[] args) {
    	
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					JanelaMenuPrincipal menuPrincipal = new JanelaMenuPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	

}
 