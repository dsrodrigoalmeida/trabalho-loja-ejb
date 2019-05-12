
package br.com.rodrigoale.web;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import br.com.rodrigoale.negocio.biz.bean.EstoqueBean;

@MessageDriven(name = "RepEstoqueBean", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/RepEstoqueBean"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })

public class RepEstoqueBean implements MessageListener {
	@EJB
	private EstoqueBean bean;
	int quantidade_reposicao;
	int id;
	
	public void onMessage(Message rcvMessage) {
		TextMessage msg = null;
		try {
				msg = (TextMessage) rcvMessage;
				String[] arrayPedidoRep= msg.getText().split(":");
			for(int i=0; i < arrayPedidoRep.length; i+=6) {
					System.out.println("Recebendo  reposição de " + arrayPedidoRep[i+3]);
					quantidade_reposicao = Integer.parseInt(arrayPedidoRep[i+5]) *3;
					System.out.println("Quantidade colocada: "+ quantidade_reposicao);
					id = Integer.parseInt(arrayPedidoRep[i+1]);
					bean.aumentarEstoque(id, quantidade_reposicao);
					
				}
		
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}