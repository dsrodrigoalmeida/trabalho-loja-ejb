
package br.com.rodrigoale.web;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

@MessageDriven(name = "PedidoRepBean", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/PedidoRepBean"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })

@JMSDestinationDefinitions(value = {
		@JMSDestinationDefinition(name = "java:/queue/RepEstoqueBean", interfaceName = "javax.jms.Queue", destinationName = "RepEstoqueBean") })


public class PedidoRepBean implements MessageListener {
	TextMessage msg = null;
	@Inject
	private JMSContext context2;

	@Resource(lookup = "java:/queue/RepEstoqueBean")
	private Queue queue2;

	public void onMessage(Message rcvMessage) {

		try {

			msg = (TextMessage) rcvMessage;
			String[] arrayPedidoRep = msg.getText().split(":");
			System.out.println(arrayPedidoRep.length);
		for(int i=0; i < arrayPedidoRep.length; i+=6) {
				System.out.println("Recebendo pedido de reposição de " + arrayPedidoRep[i+3]);
				System.out.println("Quantidade necessaria: "+ arrayPedidoRep[i+5]);
			}
			mandamsg(msg.getText());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	private void mandamsg(String pedidoRepString) {
		final Destination destination = queue2;		
		context2.createProducer().send(destination, pedidoRepString);
	}

}
