package run;

import static com.google.common.base.Preconditions.checkArgument;


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketFactory extends javax.net.SocketFactory {
    private static final Logger logger = Logger.getLogger(SocketFactory.class.getName());

    private final String instanceName;

    public SocketFactory(String instanceName) {
        checkArgument(
                instanceName != null,
                "socketFactoryArg property not set. Please specify this property in the JDBC "
                        + "URL or the connection Properties with the instance connection name in "
                        + "form \"project:region:instance\"");
        this.instanceName = instanceName;
    }

    @Override
    public Socket createSocket() throws IOException {
        logger.info(String.format("Connecting to Cloud SQL instance [%s].", instanceName));
        return SslSocketFactory.getInstance().create(instanceName);
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort)
            throws IOException {
        throw new UnsupportedOperationException();
    }
}