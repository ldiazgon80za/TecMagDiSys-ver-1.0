/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Menuitem;

/**
 *
 * @author Abde
 */
public class LongOperationComposer extends SelectorComposer<Component>{

    @Wire
    private Menuitem procButton;
     @Wire
     private Menuitem procButton2;
   
    
    @Listen("onClick=#procButton")
    public void onBusy() {
       
        Clients.showBusy("System is processing your request");
        Events.echoEvent("onLongOp", procButton, null);
    }

     @Listen("onClick=#procButton2")
    public void onBusy2() {
       
        Clients.showBusy("System is processing your request");
        Events.echoEvent("onLongOp", procButton2, null);
    }

    public Menuitem getProcButton2() {
        return procButton2;
    }

    public void setProcButton2(Menuitem procButton2) {
        this.procButton2 = procButton2;
    }

    
    public Menuitem getProcButton() {
        return procButton;
    }

    public void setProcButton(Menuitem procButton) {
        this.procButton = procButton;
    }

    
   

}
