/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemacaja;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author STARK
 */
public class JIFRecSolicitud extends javax.swing.JInternalFrame {
    int solic, esc;
    int numeroRecibo =0, nextNumero=0;
    String costo;
    conexion con = new conexion();
    private PrintRecibo jasper;
    /**
     * Creates new form JIFRecSolicitud
     */
    public JIFRecSolicitud() {
        initComponents();
        PanelChecks.setColorPrimario(new Color(0, 0, 0, 100));
        PanelOpciones.setColorPrimario(new Color(0, 0, 0, 100));
        PanelBusqueda.setColorPrimario(new Color(0, 0, 0, 100));
        PanelTotal.setColorPrimario(new Color(0, 0, 0, 100));
        txtNumSolicitud.requestFocus();
        //
        jasper=new PrintRecibo();
        
        this.lblcodUsu.setVisible(true);
        desactiva();
    }
     public double HallarTotal(int cantidad, double precio)
    {
        Double total = cantidad * precio;
        return total;
    }
    
    public void SumaTotal()
    {
        double a = Double.parseDouble(this.txtTotalBusqueda.getText());
        double b = Double.parseDouble(this.txtTotalCalificacion.getText());
        double c = Double.parseDouble(this.txtTotalTestimonio.getText());
        double d = Double.parseDouble(this.txtTotalCopiaSimple.getText());
        double e = Double.parseDouble(this.txtTotalCopiaCertificada.getText());
        double f = Double.parseDouble(this.txtTotalCCPartidas.getText());
        double g = Double.parseDouble(this.txtTotalConstancia.getText());
        double h = Double.parseDouble(this.txtTotalExhibicion.getText());
        double i = Double.parseDouble(this.txtTotalFotocopias.getText());
        double j = Double.parseDouble(this.txtTotalTramiteAdministrativo.getText());
        double k = Double.parseDouble(this.txtTotalRegularizacionEscritura.getText());
        double l = Double.parseDouble(this.txtTotalTramiteRegistrosPublicos.getText());
        double m = Double.parseDouble(this.txtTotalAnotacionMarginal.getText());
        double n = Double.parseDouble(this.txtTotalPeritaje.getText());
        double o = Double.parseDouble(this.txtTotalOtros.getText());
        
        
        double suma = a+b+c+d+e+f+g+h+i+j+k+l+m+n+o;
        //Redondear
        float rpta = (float) (Math.rint(suma*10)/10);
        this.txtTotal.setText(rpta+"");
    }


  
  
       
    public void desactiva(){
        //Desactiva todos los botones
        this.txtNumSolicitud.setEnabled(false);
        this.txtNombreUsuario.setEnabled(false);
        
        this.chkBusqueda.setEnabled(false);
        this.chkCalificacion.setEnabled(false);
        this.chkTestimonio.setEnabled(false);
        this.chkCopiaSimple.setEnabled(false);
        this.chkCopiaCertificada.setEnabled(false);
        this.chkCCPartidas.setEnabled(false);
        this.chkConstancia.setEnabled(false);
        this.chkExhibicion.setEnabled(false);
        this.chkFotocopias.setEnabled(false);
        this.chkTramiteAdministrativo.setEnabled(false);
        this.chkRegularizacionEscritura.setEnabled(false);
        this.chkTramiteRegistrosPublicos.setEnabled(false);
        this.chkAnotacionMarginal.setEnabled(false);
        this.chkPeritaje.setEnabled(false);
        this.chkOtros.setEnabled(false);
        this.txtOtros.setEnabled(false);
        this.txtEfectivo.setEnabled(false);
        this.txtTotal.setEnabled(false);
        
        this.btnBuscarSolicitud.setEnabled(false);
        this.btnGuardar.setEnabled(false);
        this.btnImprimir.setEnabled(false);
    }
    public void activa(){
        //Desactiva todos los botones
        this.txtNumSolicitud.setEnabled(true);
        this.txtNombreUsuario.setEnabled(true);
        
        this.chkBusqueda.setEnabled(true);
        this.chkCalificacion.setEnabled(true);
        this.chkTestimonio.setEnabled(true);
        this.chkCopiaSimple.setEnabled(true);
        this.chkCopiaCertificada.setEnabled(true);
        this.chkCCPartidas.setEnabled(true);
        this.chkConstancia.setEnabled(true);
        this.chkExhibicion.setEnabled(true);
        this.chkFotocopias.setEnabled(true);
        this.chkTramiteAdministrativo.setEnabled(true);
        this.chkRegularizacionEscritura.setEnabled(true);
        this.chkTramiteRegistrosPublicos.setEnabled(true);
        this.chkAnotacionMarginal.setEnabled(true);
        this.chkPeritaje.setEnabled(true);
        this.chkOtros.setEnabled(true);
        this.txtOtros.setEnabled(true);
        this.txtEfectivo.setEnabled(true);
        this.txtTotal.setEnabled(true);
        
        this.btnBuscarSolicitud.setEnabled(true);
        this.btnImprimir.setEnabled(true);
    }
    
    public void limpiar(){
        this.txtNumSolicitud.setText("");
        this.txtNombreUsuario.setText("");
        this.txtOtros.setText("");
        this.txtEfectivo.setText("");
        this.txtTotal.setText("");
        this.lbCambia.setText("");
        this.lblcodUsu.setText("");

        this.chkBusqueda.setSelected(false);
        this.chkCalificacion.setSelected(false);
        this.chkTestimonio.setSelected(false);
        this.chkCopiaSimple.setSelected(false);
        this.chkCopiaCertificada.setSelected(false);
        this.chkCCPartidas.setSelected(false);
        this.chkConstancia.setSelected(false);
        this.chkExhibicion.setSelected(false);
        this.chkFotocopias.setSelected(false);
        this.chkTramiteAdministrativo.setSelected(false);
        this.chkRegularizacionEscritura.setSelected(false); 
        this.chkTramiteRegistrosPublicos.setSelected(false);
        this.chkAnotacionMarginal.setSelected(false);
        this.chkPeritaje.setSelected(false);
        this.chkOtros.setSelected(false);
        
        this.txtCantidadBusqueda.setText("0");
        this.txtCantidadCalificacion.setText("0");
        this.txtCantidadTestimonio.setText("0");
        this.txtCantidadCopiaSimple.setText("0");
        this.txtCantidadCopiaCertificada.setText("0");
        this.txtCantidadCCPartidas.setText("0");
        this.txtCantidadConstancia.setText("0");
        this.txtCantidadExhibicion.setText("0");
        this.txtCantidadFotocopias.setText("0");
        this.txtCantidadTramiteAdministrativo.setText("0");
        this.txtCantidadRegularizacionEscritura.setText("0"); 
        this.txtCantidadTramiteRegistrosPublicos.setText("0");
        this.txtCantidadAnotacionMarginal.setText("0");
        this.txtCantidadPeritaje.setText("0");
        this.txtCantidadOtros.setText("0");
        
                this.txtPrecioUnitarioBusqueda.setText("0.0");
        this.txtPrecioUnitarioCalificacion.setText("0.0");
        this.txtPrecioUnitarioTestimonio.setText("0.0");
        this.txtPrecioUnitarioCopiaSimple.setText("0.0");
        this.txtPrecioUnitarioCopiaCertificada.setText("0.0");
        this.txtPrecioUnitarioCCPartidas.setText("0.0");
        this.txtPrecioUnitarioConstancia.setText("0.0");
        this.txtPrecioUnitarioExhibicion.setText("0.0");
        this.txtPrecioUnitarioFotocopias.setText("0.0");
        this.txtPrecioUnitarioTramiteAdministrativo.setText("0.0");
        this.txtPrecioUnitarioRegularizacionEscritura.setText("0.0"); 
        this.txtPrecioUnitarioTramiteRegistrosPublicos.setText("0.0");
        this.txtPrecioUnitarioAnotacionMarginal.setText("0.0");
        this.txtPrecioUnitarioPeritaje.setText("0.0");
        this.txtPrecioUnitarioOtros.setText("0.0");
        
        this.txtTotalBusqueda.setText("0.0");
        this.txtTotalCalificacion.setText("0.0");
        this.txtTotalTestimonio.setText("0.0");
        this.txtTotalCopiaSimple.setText("0.0");
        this.txtTotalCopiaCertificada.setText("0.0");
        this.txtTotalCCPartidas.setText("0.0");
        this.txtTotalConstancia.setText("0.0");
        this.txtTotalExhibicion.setText("0.0");
        this.txtTotalFotocopias.setText("0.0");
        this.txtTotalTramiteAdministrativo.setText("0.0");
        this.txtTotalRegularizacionEscritura.setText("0.0"); 
        this.txtTotalTramiteRegistrosPublicos.setText("0.0");
        this.txtTotalAnotacionMarginal.setText("0.0");
        this.txtTotalPeritaje.setText("0.0");
        this.txtTotalOtros.setText("0.0");
        
        this.btnGuardar.setEnabled(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(0,0,0,100));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        PanelBusqueda = new org.edisoncor.gui.panel.Panel();
        btnBuscarSolicitud = new javax.swing.JButton();
        txtNumSolicitud = new javax.swing.JTextField();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        lblNumeroRecibo = new org.edisoncor.gui.label.LabelMetric();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        jSeparator2 = new javax.swing.JSeparator();
        labelMetric3 = new org.edisoncor.gui.label.LabelMetric();
        txtNombreUsuario = new javax.swing.JTextField();
        PanelOpciones = new org.edisoncor.gui.panel.Panel();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        btnImprimir = new javax.swing.JButton();
        btnReImprimir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelMetric40 = new org.edisoncor.gui.label.LabelMetric();
        LblTengo = new org.edisoncor.gui.label.LabelMetric();
        txtEfectivo = new javax.swing.JTextField();
        lbCambia = new javax.swing.JTextField();
        LblDebo = new org.edisoncor.gui.label.LabelMetric();
        lblcodUsu = new javax.swing.JLabel();
        labelMetric41 = new org.edisoncor.gui.label.LabelMetric();
        jSeparator3 = new javax.swing.JSeparator();
        PanelChecks = new org.edisoncor.gui.panel.Panel();
        txtOtros = new javax.swing.JTextField();
        chkOtros = new javax.swing.JCheckBox();
        chkPeritaje = new javax.swing.JCheckBox();
        chkAnotacionMarginal = new javax.swing.JCheckBox();
        chkTramiteRegistrosPublicos = new javax.swing.JCheckBox();
        chkRegularizacionEscritura = new javax.swing.JCheckBox();
        chkTramiteAdministrativo = new javax.swing.JCheckBox();
        chkFotocopias = new javax.swing.JCheckBox();
        chkExhibicion = new javax.swing.JCheckBox();
        chkConstancia = new javax.swing.JCheckBox();
        chkCCPartidas = new javax.swing.JCheckBox();
        chkCopiaCertificada = new javax.swing.JCheckBox();
        chkCopiaSimple = new javax.swing.JCheckBox();
        chkTestimonio = new javax.swing.JCheckBox();
        chkCalificacion = new javax.swing.JCheckBox();
        chkBusqueda = new javax.swing.JCheckBox();
        labelMetric4 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric6 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric7 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric8 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric9 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalBusqueda = new org.edisoncor.gui.label.LabelMetric();
        labelMetric10 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalCalificacion = new org.edisoncor.gui.label.LabelMetric();
        txtTotalTestimonio = new org.edisoncor.gui.label.LabelMetric();
        labelMetric11 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalCopiaSimple = new org.edisoncor.gui.label.LabelMetric();
        labelMetric12 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric13 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalCopiaCertificada = new org.edisoncor.gui.label.LabelMetric();
        txtTotalCCPartidas = new org.edisoncor.gui.label.LabelMetric();
        labelMetric14 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalConstancia = new org.edisoncor.gui.label.LabelMetric();
        labelMetric15 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric16 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalExhibicion = new org.edisoncor.gui.label.LabelMetric();
        labelMetric17 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalFotocopias = new org.edisoncor.gui.label.LabelMetric();
        txtTotalTramiteAdministrativo = new org.edisoncor.gui.label.LabelMetric();
        labelMetric18 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalRegularizacionEscritura = new org.edisoncor.gui.label.LabelMetric();
        labelMetric19 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric20 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalTramiteRegistrosPublicos = new org.edisoncor.gui.label.LabelMetric();
        labelMetric21 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalAnotacionMarginal = new org.edisoncor.gui.label.LabelMetric();
        txtTotalPeritaje = new org.edisoncor.gui.label.LabelMetric();
        labelMetric22 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric23 = new org.edisoncor.gui.label.LabelMetric();
        txtTotalOtros = new org.edisoncor.gui.label.LabelMetric();
        labelMetric24 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric25 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric26 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric27 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric28 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric29 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric30 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric31 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric32 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric33 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric34 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric35 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric36 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric37 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric38 = new org.edisoncor.gui.label.LabelMetric();
        txtPrecioUnitarioBusqueda = new javax.swing.JTextField();
        txtPrecioUnitarioCalificacion = new javax.swing.JTextField();
        txtPrecioUnitarioTestimonio = new javax.swing.JTextField();
        txtPrecioUnitarioCopiaSimple = new javax.swing.JTextField();
        txtPrecioUnitarioCopiaCertificada = new javax.swing.JTextField();
        txtPrecioUnitarioCCPartidas = new javax.swing.JTextField();
        txtPrecioUnitarioConstancia = new javax.swing.JTextField();
        txtPrecioUnitarioExhibicion = new javax.swing.JTextField();
        txtPrecioUnitarioFotocopias = new javax.swing.JTextField();
        txtPrecioUnitarioTramiteAdministrativo = new javax.swing.JTextField();
        txtPrecioUnitarioRegularizacionEscritura = new javax.swing.JTextField();
        txtPrecioUnitarioTramiteRegistrosPublicos = new javax.swing.JTextField();
        txtPrecioUnitarioAnotacionMarginal = new javax.swing.JTextField();
        txtPrecioUnitarioPeritaje = new javax.swing.JTextField();
        txtPrecioUnitarioOtros = new javax.swing.JTextField();
        txtCantidadBusqueda = new javax.swing.JTextField();
        txtCantidadCalificacion = new javax.swing.JTextField();
        txtCantidadTestimonio = new javax.swing.JTextField();
        txtCantidadCopiaSimple = new javax.swing.JTextField();
        txtCantidadCopiaCertificada = new javax.swing.JTextField();
        txtCantidadCCPartidas = new javax.swing.JTextField();
        txtCantidadConstancia = new javax.swing.JTextField();
        txtCantidadExhibicion = new javax.swing.JTextField();
        txtCantidadFotocopias = new javax.swing.JTextField();
        txtCantidadTramiteAdministrativo = new javax.swing.JTextField();
        txtCantidadRegularizacionEscritura = new javax.swing.JTextField();
        txtCantidadTramiteRegistrosPublicos = new javax.swing.JTextField();
        txtCantidadAnotacionMarginal = new javax.swing.JTextField();
        txtCantidadPeritaje = new javax.swing.JTextField();
        txtCantidadOtros = new javax.swing.JTextField();
        PanelTotal = new org.edisoncor.gui.panel.Panel();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        labelMetric39 = new org.edisoncor.gui.label.LabelMetric();
        txtTotal = new org.edisoncor.gui.label.LabelHeader();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 153), 4));
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTROS POR SOLICITUD");
        setMaximumSize(new java.awt.Dimension(773, 692));
        setMinimumSize(new java.awt.Dimension(773, 692));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(773, 692));

        panelImage1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 255)));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siscajaImagenes/fondoJIF.jpg"))); // NOI18N
        panelImage1.setMaximumSize(new java.awt.Dimension(763, 715));
        panelImage1.setMinimumSize(new java.awt.Dimension(763, 715));
        panelImage1.setPreferredSize(new java.awt.Dimension(763, 715));

        PanelBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        PanelBusqueda.setColorPrimario(new java.awt.Color(0, 0, 0));
        PanelBusqueda.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelBusquedaMouseMoved(evt);
            }
        });

        btnBuscarSolicitud.setFont(new java.awt.Font("AgencyFB", 0, 18)); // NOI18N
        btnBuscarSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png"))); // NOI18N
        btnBuscarSolicitud.setText("    BUSCAR");
        btnBuscarSolicitud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnBuscarSolicitud.setContentAreaFilled(false);
        btnBuscarSolicitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarSolicitud.setMaximumSize(new java.awt.Dimension(159, 36));
        btnBuscarSolicitud.setMinimumSize(new java.awt.Dimension(159, 36));
        btnBuscarSolicitud.setPreferredSize(new java.awt.Dimension(159, 36));
        btnBuscarSolicitud.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnBuscarSolicitudMouseMoved(evt);
            }
        });
        btnBuscarSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnBuscarSolicitudMouseReleased(evt);
            }
        });
        btnBuscarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSolicitudActionPerformed(evt);
            }
        });

        txtNumSolicitud.setBackground(new java.awt.Color(0, 0, 0));
        txtNumSolicitud.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtNumSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        txtNumSolicitud.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumSolicitud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtNumSolicitud.setMaximumSize(new java.awt.Dimension(99, 36));
        txtNumSolicitud.setMinimumSize(new java.awt.Dimension(99, 36));
        txtNumSolicitud.setPreferredSize(new java.awt.Dimension(99, 36));
        txtNumSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSolicitudActionPerformed(evt);
            }
        });
        txtNumSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumSolicitudKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumSolicitudKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumSolicitudKeyTyped(evt);
            }
        });

        labelMetric1.setText("Nº SOLICITUD");
        labelMetric1.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric1.setDistanciaDeSombra(2);
        labelMetric1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        lblNumeroRecibo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        lblNumeroRecibo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumeroRecibo.setText("0");
        lblNumeroRecibo.setToolTipText("");
        lblNumeroRecibo.setColorDeSombra(new java.awt.Color(0, 102, 153));
        lblNumeroRecibo.setDistanciaDeSombra(2);
        lblNumeroRecibo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNumeroRecibo.setMaximumSize(new java.awt.Dimension(85, 36));
        lblNumeroRecibo.setMinimumSize(new java.awt.Dimension(85, 36));
        lblNumeroRecibo.setPreferredSize(new java.awt.Dimension(85, 36));

        labelMetric2.setText("Nº RECIBO");
        labelMetric2.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric2.setDistanciaDeSombra(2);
        labelMetric2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jSeparator2.setBackground(new java.awt.Color(0, 153, 255));
        jSeparator2.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator2.setOpaque(true);

        labelMetric3.setText("RECIBI DE");
        labelMetric3.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric3.setDistanciaDeSombra(2);
        labelMetric3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelMetric3.setMaximumSize(new java.awt.Dimension(100, 30));
        labelMetric3.setMinimumSize(new java.awt.Dimension(100, 30));
        labelMetric3.setPreferredSize(new java.awt.Dimension(100, 30));

        txtNombreUsuario.setFont(new java.awt.Font("AgencyFB", 1, 24)); // NOI18N
        txtNombreUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreUsuario.setText("JUAN PERICO PEREZ");
        txtNombreUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtNombreUsuario.setMaximumSize(new java.awt.Dimension(144, 30));
        txtNombreUsuario.setMinimumSize(new java.awt.Dimension(144, 30));
        txtNombreUsuario.setPreferredSize(new java.awt.Dimension(144, 30));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBusquedaLayout = new javax.swing.GroupLayout(PanelBusqueda);
        PanelBusqueda.setLayout(PanelBusquedaLayout);
        PanelBusquedaLayout.setHorizontalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBusquedaLayout.createSequentialGroup()
                        .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelBusquedaLayout.createSequentialGroup()
                        .addComponent(labelMetric1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNumSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumeroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelBusquedaLayout.setVerticalGroup(
            PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNumSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblNumeroRecibo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelBusquedaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        PanelOpciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        PanelOpciones.setColorPrimario(new java.awt.Color(0, 0, 0));
        PanelOpciones.setMaximumSize(new java.awt.Dimension(155, 247));
        PanelOpciones.setMinimumSize(new java.awt.Dimension(155, 247));

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Agregar.png"))); // NOI18N
        btnNuevo.setText("   NUEVO");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setMaximumSize(new java.awt.Dimension(95, 63));
        btnNuevo.setMinimumSize(new java.awt.Dimension(95, 63));
        btnNuevo.setPreferredSize(new java.awt.Dimension(95, 63));
        btnNuevo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnNuevoMouseMoved(evt);
            }
        });
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnNuevoMouseReleased(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btnCancelar.setText("   CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setMaximumSize(new java.awt.Dimension(95, 63));
        btnCancelar.setMinimumSize(new java.awt.Dimension(95, 63));
        btnCancelar.setPreferredSize(new java.awt.Dimension(95, 63));
        btnCancelar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCancelarMouseMoved(evt);
            }
        });
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCancelarMouseReleased(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        btnGuardar.setText("   GUARDAR");
        btnGuardar.setToolTipText("");
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setMaximumSize(new java.awt.Dimension(95, 63));
        btnGuardar.setMinimumSize(new java.awt.Dimension(95, 63));
        btnGuardar.setPreferredSize(new java.awt.Dimension(95, 63));
        btnGuardar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnGuardarMouseMoved(evt);
            }
        });
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(0, 153, 255));
        jSeparator8.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator8.setOpaque(true);

        btnImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imprimir.png"))); // NOI18N
        btnImprimir.setText("   IMPRIMIR");
        btnImprimir.setToolTipText("");
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setMaximumSize(new java.awt.Dimension(95, 63));
        btnImprimir.setMinimumSize(new java.awt.Dimension(95, 63));
        btnImprimir.setPreferredSize(new java.awt.Dimension(95, 63));
        btnImprimir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnImprimirMouseMoved(evt);
            }
        });
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnImprimirMouseReleased(evt);
            }
        });
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnReImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnReImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnReImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/impresora.png"))); // NOI18N
        btnReImprimir.setText("   RE-IMPRIMIR");
        btnReImprimir.setToolTipText("");
        btnReImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        btnReImprimir.setContentAreaFilled(false);
        btnReImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReImprimir.setMaximumSize(new java.awt.Dimension(95, 63));
        btnReImprimir.setMinimumSize(new java.awt.Dimension(95, 63));
        btnReImprimir.setPreferredSize(new java.awt.Dimension(95, 63));
        btnReImprimir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnReImprimirMouseMoved(evt);
            }
        });
        btnReImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnReImprimirMouseReleased(evt);
            }
        });
        btnReImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReImprimirActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator1.setOpaque(true);

        labelMetric40.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 255)));
        labelMetric40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric40.setText("CAMBIO");
        labelMetric40.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelMetric40.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        labelMetric40.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        LblTengo.setText("EFECTIVO:");

        txtEfectivo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEfectivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtEfectivo.setMaximumSize(new java.awt.Dimension(133, 25));
        txtEfectivo.setMinimumSize(new java.awt.Dimension(133, 25));
        txtEfectivo.setPreferredSize(new java.awt.Dimension(133, 25));
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });

        lbCambia.setEditable(false);
        lbCambia.setBackground(new java.awt.Color(0, 0, 0));
        lbCambia.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbCambia.setForeground(new java.awt.Color(255, 255, 255));
        lbCambia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbCambia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        lbCambia.setMaximumSize(new java.awt.Dimension(133, 25));
        lbCambia.setMinimumSize(new java.awt.Dimension(133, 25));
        lbCambia.setPreferredSize(new java.awt.Dimension(133, 25));

        LblDebo.setText("CAMBIO:");

        labelMetric41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 255)));
        labelMetric41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric41.setText("OPCIONES");

        jSeparator3.setBackground(new java.awt.Color(0, 153, 255));
        jSeparator3.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator3.setOpaque(true);

        javax.swing.GroupLayout PanelOpcionesLayout = new javax.swing.GroupLayout(PanelOpciones);
        PanelOpciones.setLayout(PanelOpcionesLayout);
        PanelOpcionesLayout.setHorizontalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMetric40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelMetric41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator8)
            .addComponent(jSeparator1)
            .addComponent(jSeparator3)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addComponent(LblDebo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcodUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblTengo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelOpcionesLayout.createSequentialGroup()
                        .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCambia, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOpcionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        PanelOpcionesLayout.setVerticalGroup(
            PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOpcionesLayout.createSequentialGroup()
                .addComponent(labelMetric41, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelMetric40, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTengo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblDebo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCambia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelChecks.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        PanelChecks.setColorPrimario(new java.awt.Color(0, 0, 0));
        PanelChecks.setGradiente(org.edisoncor.gui.panel.Panel.Gradiente.CIRCULAR);

        txtOtros.setBackground(new java.awt.Color(0, 0, 0));
        txtOtros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtOtros.setForeground(new java.awt.Color(255, 255, 255));
        txtOtros.setText("...");
        txtOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtOtros.setMaximumSize(new java.awt.Dimension(252, 25));
        txtOtros.setMinimumSize(new java.awt.Dimension(252, 25));
        txtOtros.setOpaque(false);
        txtOtros.setPreferredSize(new java.awt.Dimension(252, 25));
        txtOtros.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtOtrosMouseMoved(evt);
            }
        });
        txtOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtrosActionPerformed(evt);
            }
        });

        chkOtros.setContentAreaFilled(false);
        chkOtros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOtrosActionPerformed(evt);
            }
        });

        chkPeritaje.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkPeritaje.setForeground(new java.awt.Color(255, 255, 255));
        chkPeritaje.setText("PERITAJE");
        chkPeritaje.setContentAreaFilled(false);
        chkPeritaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkPeritaje.setIconTextGap(25);
        chkPeritaje.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkPeritajeMouseMoved(evt);
            }
        });
        chkPeritaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPeritajeActionPerformed(evt);
            }
        });

        chkAnotacionMarginal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkAnotacionMarginal.setForeground(new java.awt.Color(255, 255, 255));
        chkAnotacionMarginal.setText("ANOTACION MARGINAL");
        chkAnotacionMarginal.setContentAreaFilled(false);
        chkAnotacionMarginal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkAnotacionMarginal.setIconTextGap(25);
        chkAnotacionMarginal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkAnotacionMarginalMouseMoved(evt);
            }
        });
        chkAnotacionMarginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAnotacionMarginalActionPerformed(evt);
            }
        });

        chkTramiteRegistrosPublicos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkTramiteRegistrosPublicos.setForeground(new java.awt.Color(255, 255, 255));
        chkTramiteRegistrosPublicos.setText("TRAMITE EN REGISTROS PUBLICOS");
        chkTramiteRegistrosPublicos.setContentAreaFilled(false);
        chkTramiteRegistrosPublicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkTramiteRegistrosPublicos.setIconTextGap(25);
        chkTramiteRegistrosPublicos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkTramiteRegistrosPublicosMouseMoved(evt);
            }
        });
        chkTramiteRegistrosPublicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTramiteRegistrosPublicosActionPerformed(evt);
            }
        });

        chkRegularizacionEscritura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkRegularizacionEscritura.setForeground(new java.awt.Color(255, 255, 255));
        chkRegularizacionEscritura.setText("REGULARIZACION DE ESCRITURA");
        chkRegularizacionEscritura.setContentAreaFilled(false);
        chkRegularizacionEscritura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkRegularizacionEscritura.setIconTextGap(25);
        chkRegularizacionEscritura.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkRegularizacionEscrituraMouseMoved(evt);
            }
        });
        chkRegularizacionEscritura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRegularizacionEscrituraActionPerformed(evt);
            }
        });

        chkTramiteAdministrativo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkTramiteAdministrativo.setForeground(new java.awt.Color(255, 255, 255));
        chkTramiteAdministrativo.setText("TRAMITE ADMINISTRATIVO");
        chkTramiteAdministrativo.setContentAreaFilled(false);
        chkTramiteAdministrativo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkTramiteAdministrativo.setIconTextGap(25);
        chkTramiteAdministrativo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkTramiteAdministrativoMouseMoved(evt);
            }
        });
        chkTramiteAdministrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTramiteAdministrativoActionPerformed(evt);
            }
        });

        chkFotocopias.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkFotocopias.setForeground(new java.awt.Color(255, 255, 255));
        chkFotocopias.setText("FOTOCOPIAS");
        chkFotocopias.setContentAreaFilled(false);
        chkFotocopias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkFotocopias.setIconTextGap(25);
        chkFotocopias.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkFotocopiasMouseMoved(evt);
            }
        });
        chkFotocopias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFotocopiasActionPerformed(evt);
            }
        });

        chkExhibicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkExhibicion.setForeground(new java.awt.Color(255, 255, 255));
        chkExhibicion.setText("EXHIBICION");
        chkExhibicion.setContentAreaFilled(false);
        chkExhibicion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkExhibicion.setIconTextGap(25);
        chkExhibicion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkExhibicionMouseMoved(evt);
            }
        });
        chkExhibicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkExhibicionActionPerformed(evt);
            }
        });

        chkConstancia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkConstancia.setForeground(new java.awt.Color(255, 255, 255));
        chkConstancia.setText("CONSTANCIA");
        chkConstancia.setContentAreaFilled(false);
        chkConstancia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkConstancia.setIconTextGap(25);
        chkConstancia.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkConstanciaMouseMoved(evt);
            }
        });
        chkConstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkConstanciaActionPerformed(evt);
            }
        });

        chkCCPartidas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCCPartidas.setForeground(new java.awt.Color(255, 255, 255));
        chkCCPartidas.setText("C. C. PARTIDAS");
        chkCCPartidas.setContentAreaFilled(false);
        chkCCPartidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkCCPartidas.setIconTextGap(25);
        chkCCPartidas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkCCPartidasMouseMoved(evt);
            }
        });
        chkCCPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCCPartidasActionPerformed(evt);
            }
        });

        chkCopiaCertificada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCopiaCertificada.setForeground(new java.awt.Color(255, 255, 255));
        chkCopiaCertificada.setText("COPIA(S) CERTIFICADA(S)");
        chkCopiaCertificada.setContentAreaFilled(false);
        chkCopiaCertificada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkCopiaCertificada.setIconTextGap(25);
        chkCopiaCertificada.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkCopiaCertificadaMouseMoved(evt);
            }
        });
        chkCopiaCertificada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCopiaCertificadaActionPerformed(evt);
            }
        });

        chkCopiaSimple.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCopiaSimple.setForeground(new java.awt.Color(255, 255, 255));
        chkCopiaSimple.setText("COPIA(S) SIMPLE(S)");
        chkCopiaSimple.setContentAreaFilled(false);
        chkCopiaSimple.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkCopiaSimple.setIconTextGap(25);
        chkCopiaSimple.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkCopiaSimpleMouseMoved(evt);
            }
        });
        chkCopiaSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCopiaSimpleActionPerformed(evt);
            }
        });

        chkTestimonio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkTestimonio.setForeground(new java.awt.Color(255, 255, 255));
        chkTestimonio.setText("TESTIMONIO");
        chkTestimonio.setContentAreaFilled(false);
        chkTestimonio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkTestimonio.setIconTextGap(25);
        chkTestimonio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkTestimonioMouseMoved(evt);
            }
        });
        chkTestimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTestimonioActionPerformed(evt);
            }
        });

        chkCalificacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCalificacion.setForeground(new java.awt.Color(255, 255, 255));
        chkCalificacion.setText("CALIFICACION");
        chkCalificacion.setContentAreaFilled(false);
        chkCalificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkCalificacion.setIconTextGap(25);
        chkCalificacion.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkCalificacionMouseMoved(evt);
            }
        });
        chkCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCalificacionActionPerformed(evt);
            }
        });

        chkBusqueda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        chkBusqueda.setText("BUSQUEDA");
        chkBusqueda.setContentAreaFilled(false);
        chkBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkBusqueda.setIconTextGap(25);
        chkBusqueda.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkBusquedaMouseMoved(evt);
            }
        });
        chkBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBusquedaActionPerformed(evt);
            }
        });

        labelMetric4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 255)));
        labelMetric4.setText("ACT.");
        labelMetric4.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric4.setDistanciaDeSombra(2);

        labelMetric5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 255)));
        labelMetric5.setText("POR LO SIGUIENTE");
        labelMetric5.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric5.setDistanciaDeSombra(2);

        labelMetric6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 255)));
        labelMetric6.setText("CANT.");
        labelMetric6.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric6.setDistanciaDeSombra(2);

        labelMetric7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 255)));
        labelMetric7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric7.setText("P/U");
        labelMetric7.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric7.setDistanciaDeSombra(2);

        labelMetric8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 102, 102)));
        labelMetric8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric8.setText("TOTAL");
        labelMetric8.setColorDeSombra(new java.awt.Color(255, 0, 0));
        labelMetric8.setDistanciaDeSombra(2);

        labelMetric9.setText("S/.");
        labelMetric9.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric9.setDistanciaDeSombra(2);
        labelMetric9.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric9.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric9.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalBusqueda.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalBusqueda.setDistanciaDeSombra(1);
        txtTotalBusqueda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtTotalBusqueda.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalBusqueda.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalBusqueda.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric10.setText("S/.");
        labelMetric10.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric10.setDistanciaDeSombra(2);
        labelMetric10.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric10.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric10.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalCalificacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalCalificacion.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalCalificacion.setDistanciaDeSombra(1);
        txtTotalCalificacion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalCalificacion.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalCalificacion.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalCalificacion.setPreferredSize(new java.awt.Dimension(44, 25));

        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalTestimonio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalTestimonio.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalTestimonio.setDistanciaDeSombra(1);
        txtTotalTestimonio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalTestimonio.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalTestimonio.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalTestimonio.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric11.setText("S/.");
        labelMetric11.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric11.setDistanciaDeSombra(2);
        labelMetric11.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric11.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric11.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalCopiaSimple.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalCopiaSimple.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalCopiaSimple.setDistanciaDeSombra(1);
        txtTotalCopiaSimple.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalCopiaSimple.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalCopiaSimple.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalCopiaSimple.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric12.setText("S/.");
        labelMetric12.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric12.setDistanciaDeSombra(2);
        labelMetric12.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric12.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric12.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric13.setText("S/.");
        labelMetric13.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric13.setDistanciaDeSombra(2);
        labelMetric13.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric13.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric13.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalCopiaCertificada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalCopiaCertificada.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalCopiaCertificada.setDistanciaDeSombra(1);
        txtTotalCopiaCertificada.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalCopiaCertificada.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalCopiaCertificada.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalCopiaCertificada.setPreferredSize(new java.awt.Dimension(44, 25));

        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalCCPartidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalCCPartidas.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalCCPartidas.setDistanciaDeSombra(1);
        txtTotalCCPartidas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalCCPartidas.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalCCPartidas.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalCCPartidas.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric14.setText("S/.");
        labelMetric14.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric14.setDistanciaDeSombra(2);
        labelMetric14.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric14.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric14.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalConstancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalConstancia.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalConstancia.setDistanciaDeSombra(1);
        txtTotalConstancia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalConstancia.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalConstancia.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalConstancia.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric15.setText("S/.");
        labelMetric15.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric15.setDistanciaDeSombra(2);
        labelMetric15.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric15.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric15.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric16.setText("S/.");
        labelMetric16.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric16.setDistanciaDeSombra(2);
        labelMetric16.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric16.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric16.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalExhibicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalExhibicion.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalExhibicion.setDistanciaDeSombra(1);
        txtTotalExhibicion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalExhibicion.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalExhibicion.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalExhibicion.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric17.setText("S/.");
        labelMetric17.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric17.setDistanciaDeSombra(2);
        labelMetric17.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric17.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric17.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalFotocopias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalFotocopias.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalFotocopias.setDistanciaDeSombra(1);
        txtTotalFotocopias.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalFotocopias.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalFotocopias.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalFotocopias.setPreferredSize(new java.awt.Dimension(44, 25));

        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalTramiteAdministrativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalTramiteAdministrativo.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalTramiteAdministrativo.setDistanciaDeSombra(1);
        txtTotalTramiteAdministrativo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalTramiteAdministrativo.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalTramiteAdministrativo.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalTramiteAdministrativo.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric18.setText("S/.");
        labelMetric18.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric18.setDistanciaDeSombra(2);
        labelMetric18.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric18.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric18.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalRegularizacionEscritura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalRegularizacionEscritura.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalRegularizacionEscritura.setDistanciaDeSombra(1);
        txtTotalRegularizacionEscritura.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalRegularizacionEscritura.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalRegularizacionEscritura.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalRegularizacionEscritura.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric19.setText("S/.");
        labelMetric19.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric19.setDistanciaDeSombra(2);
        labelMetric19.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric19.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric19.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric20.setText("S/.");
        labelMetric20.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric20.setDistanciaDeSombra(2);
        labelMetric20.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric20.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric20.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalTramiteRegistrosPublicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalTramiteRegistrosPublicos.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalTramiteRegistrosPublicos.setDistanciaDeSombra(1);
        txtTotalTramiteRegistrosPublicos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalTramiteRegistrosPublicos.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalTramiteRegistrosPublicos.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalTramiteRegistrosPublicos.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric21.setText("S/.");
        labelMetric21.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric21.setDistanciaDeSombra(2);
        labelMetric21.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric21.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric21.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalAnotacionMarginal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalAnotacionMarginal.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalAnotacionMarginal.setDistanciaDeSombra(1);
        txtTotalAnotacionMarginal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalAnotacionMarginal.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalAnotacionMarginal.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalAnotacionMarginal.setPreferredSize(new java.awt.Dimension(44, 25));

        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalPeritaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalPeritaje.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalPeritaje.setDistanciaDeSombra(1);
        txtTotalPeritaje.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalPeritaje.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalPeritaje.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalPeritaje.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric22.setText("S/.");
        labelMetric22.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric22.setDistanciaDeSombra(2);
        labelMetric22.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric22.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric22.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric23.setText("S/.");
        labelMetric23.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric23.setDistanciaDeSombra(2);
        labelMetric23.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric23.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric23.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        txtTotalOtros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalOtros.setColorDeSombra(new java.awt.Color(51, 51, 51));
        txtTotalOtros.setDistanciaDeSombra(1);
        txtTotalOtros.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        txtTotalOtros.setMaximumSize(new java.awt.Dimension(44, 25));
        txtTotalOtros.setMinimumSize(new java.awt.Dimension(44, 25));
        txtTotalOtros.setPreferredSize(new java.awt.Dimension(44, 25));

        labelMetric24.setText("S/.");
        labelMetric24.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric24.setDistanciaDeSombra(2);
        labelMetric24.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric24.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric24.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric25.setText("S/.");
        labelMetric25.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric25.setDistanciaDeSombra(2);
        labelMetric25.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric25.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric25.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric26.setText("S/.");
        labelMetric26.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric26.setDistanciaDeSombra(2);
        labelMetric26.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric26.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric26.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric27.setText("S/.");
        labelMetric27.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric27.setDistanciaDeSombra(2);
        labelMetric27.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric27.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric27.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric28.setText("S/.");
        labelMetric28.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric28.setDistanciaDeSombra(2);
        labelMetric28.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric28.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric28.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric29.setText("S/.");
        labelMetric29.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric29.setDistanciaDeSombra(2);
        labelMetric29.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric29.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric29.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric30.setText("S/.");
        labelMetric30.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric30.setDistanciaDeSombra(2);
        labelMetric30.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric30.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric30.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric31.setText("S/.");
        labelMetric31.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric31.setDistanciaDeSombra(2);
        labelMetric31.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric31.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric31.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric32.setText("S/.");
        labelMetric32.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric32.setDistanciaDeSombra(2);
        labelMetric32.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric32.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric32.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric33.setText("S/.");
        labelMetric33.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric33.setDistanciaDeSombra(2);
        labelMetric33.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric33.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric33.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric34.setText("S/.");
        labelMetric34.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric34.setDistanciaDeSombra(2);
        labelMetric34.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric34.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric34.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric35.setText("S/.");
        labelMetric35.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric35.setDistanciaDeSombra(2);
        labelMetric35.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric35.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric35.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric36.setText("S/.");
        labelMetric36.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric36.setDistanciaDeSombra(2);
        labelMetric36.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric36.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric36.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric37.setText("S/.");
        labelMetric37.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric37.setDistanciaDeSombra(2);
        labelMetric37.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric37.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric37.setPreferredSize(new java.awt.Dimension(17, 25));

        labelMetric38.setText("S/.");
        labelMetric38.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric38.setDistanciaDeSombra(2);
        labelMetric38.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric38.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric38.setPreferredSize(new java.awt.Dimension(17, 25));

        txtPrecioUnitarioBusqueda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioBusqueda.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioBusqueda.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioBusqueda.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioCalificacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioCalificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioCalificacion.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCalificacion.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCalificacion.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioTestimonio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioTestimonio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioTestimonio.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioTestimonio.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioTestimonio.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioCopiaSimple.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioCopiaSimple.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioCopiaSimple.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCopiaSimple.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCopiaSimple.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioCopiaCertificada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioCopiaCertificada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioCopiaCertificada.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCopiaCertificada.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCopiaCertificada.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioCCPartidas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioCCPartidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioCCPartidas.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCCPartidas.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioCCPartidas.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioConstancia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioConstancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioConstancia.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioConstancia.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioConstancia.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioExhibicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioExhibicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioExhibicion.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioExhibicion.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioExhibicion.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioFotocopias.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioFotocopias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioFotocopias.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioFotocopias.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioFotocopias.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioTramiteAdministrativo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioTramiteAdministrativo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioTramiteAdministrativo.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioTramiteAdministrativo.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioTramiteAdministrativo.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioRegularizacionEscritura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioRegularizacionEscritura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioRegularizacionEscritura.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioRegularizacionEscritura.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioRegularizacionEscritura.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioTramiteRegistrosPublicos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioTramiteRegistrosPublicos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioTramiteRegistrosPublicos.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioTramiteRegistrosPublicos.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioAnotacionMarginal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioAnotacionMarginal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioAnotacionMarginal.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioAnotacionMarginal.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioAnotacionMarginal.setPreferredSize(new java.awt.Dimension(59, 25));

        txtPrecioUnitarioPeritaje.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioPeritaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioPeritaje.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioPeritaje.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioPeritaje.setPreferredSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioPeritaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioUnitarioPeritajeKeyPressed(evt);
            }
        });

        txtPrecioUnitarioOtros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPrecioUnitarioOtros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtPrecioUnitarioOtros.setMaximumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioOtros.setMinimumSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioOtros.setPreferredSize(new java.awt.Dimension(59, 25));
        txtPrecioUnitarioOtros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioUnitarioOtrosKeyPressed(evt);
            }
        });

        txtCantidadBusqueda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadBusqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadBusqueda.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadBusqueda.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadBusqueda.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadBusquedaActionPerformed(evt);
            }
        });
        txtCantidadBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadBusquedaKeyPressed(evt);
            }
        });

        txtCantidadCalificacion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadCalificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadCalificacion.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadCalificacion.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadCalificacion.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadCalificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadCalificacionKeyPressed(evt);
            }
        });

        txtCantidadTestimonio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadTestimonio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadTestimonio.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadTestimonio.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadTestimonio.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadTestimonio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadTestimonioKeyPressed(evt);
            }
        });

        txtCantidadCopiaSimple.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadCopiaSimple.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadCopiaSimple.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadCopiaSimple.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadCopiaSimple.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadCopiaSimple.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadCopiaSimpleKeyPressed(evt);
            }
        });

        txtCantidadCopiaCertificada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadCopiaCertificada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadCopiaCertificada.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadCopiaCertificada.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadCopiaCertificada.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadCopiaCertificada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadCopiaCertificadaKeyPressed(evt);
            }
        });

        txtCantidadCCPartidas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadCCPartidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadCCPartidas.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadCCPartidas.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadCCPartidas.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadCCPartidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadCCPartidasKeyPressed(evt);
            }
        });

        txtCantidadConstancia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadConstancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadConstancia.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadConstancia.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadConstancia.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadConstancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadConstanciaKeyPressed(evt);
            }
        });

        txtCantidadExhibicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadExhibicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadExhibicion.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadExhibicion.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadExhibicion.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadExhibicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadExhibicionKeyPressed(evt);
            }
        });

        txtCantidadFotocopias.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadFotocopias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadFotocopias.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadFotocopias.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadFotocopias.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadFotocopias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadFotocopiasKeyPressed(evt);
            }
        });

        txtCantidadTramiteAdministrativo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadTramiteAdministrativo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadTramiteAdministrativo.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadTramiteAdministrativo.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadTramiteAdministrativo.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadTramiteAdministrativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadTramiteAdministrativoKeyPressed(evt);
            }
        });

        txtCantidadRegularizacionEscritura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadRegularizacionEscritura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadRegularizacionEscritura.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadRegularizacionEscritura.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadRegularizacionEscritura.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadRegularizacionEscritura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadRegularizacionEscrituraActionPerformed(evt);
            }
        });
        txtCantidadRegularizacionEscritura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadRegularizacionEscrituraKeyPressed(evt);
            }
        });

        txtCantidadTramiteRegistrosPublicos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadTramiteRegistrosPublicos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadTramiteRegistrosPublicos.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadTramiteRegistrosPublicos.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadTramiteRegistrosPublicos.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadTramiteRegistrosPublicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadTramiteRegistrosPublicosKeyPressed(evt);
            }
        });

        txtCantidadAnotacionMarginal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadAnotacionMarginal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadAnotacionMarginal.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadAnotacionMarginal.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadAnotacionMarginal.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadAnotacionMarginal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadAnotacionMarginalKeyPressed(evt);
            }
        });

        txtCantidadPeritaje.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadPeritaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadPeritaje.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadPeritaje.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadPeritaje.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadPeritaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadPeritajeKeyPressed(evt);
            }
        });

        txtCantidadOtros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCantidadOtros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtCantidadOtros.setMaximumSize(new java.awt.Dimension(40, 25));
        txtCantidadOtros.setMinimumSize(new java.awt.Dimension(40, 25));
        txtCantidadOtros.setPreferredSize(new java.awt.Dimension(40, 25));
        txtCantidadOtros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadOtrosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelChecksLayout = new javax.swing.GroupLayout(PanelChecks);
        PanelChecks.setLayout(PanelChecksLayout);
        PanelChecksLayout.setHorizontalGroup(
            PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChecksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(chkAnotacionMarginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkTramiteRegistrosPublicos, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addComponent(chkRegularizacionEscritura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkTramiteAdministrativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkFotocopias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkExhibicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkConstancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkCCPartidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkCopiaCertificada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkCopiaSimple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkTestimonio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkOtros, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chkPeritaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(txtCantidadPeritaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadAnotacionMarginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadTramiteRegistrosPublicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadRegularizacionEscritura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadTramiteAdministrativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadFotocopias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadExhibicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadConstancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadCCPartidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadCopiaCertificada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadCopiaSimple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadTestimonio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadOtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCantidadBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMetric25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMetric7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioPeritaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioAnotacionMarginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioOtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioTestimonio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioCopiaSimple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioCopiaCertificada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioCCPartidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioConstancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioExhibicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioFotocopias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioTramiteAdministrativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioRegularizacionEscritura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioTramiteRegistrosPublicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitarioBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric20, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalTramiteRegistrosPublicos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalRegularizacionEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric18, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalTramiteAdministrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalFotocopias, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalExhibicion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalCCPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalCopiaCertificada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalCopiaSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalTestimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalAnotacionMarginal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalPeritaje, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric23, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelMetric8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txtTotalBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelChecksLayout.setVerticalGroup(
            PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChecksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalTestimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCopiaSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCopiaCertificada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCCPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalExhibicion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalFotocopias, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalTramiteAdministrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalRegularizacionEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalTramiteRegistrosPublicos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalAnotacionMarginal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalPeritaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelChecksLayout.createSequentialGroup()
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelChecksLayout.createSequentialGroup()
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelChecksLayout.createSequentialGroup()
                                        .addComponent(labelMetric38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelMetric37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelMetric27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChecksLayout.createSequentialGroup()
                                        .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(PanelChecksLayout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(txtPrecioUnitarioTestimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(txtPrecioUnitarioCopiaCertificada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioUnitarioCCPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioUnitarioConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioUnitarioExhibicion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(124, 124, 124))
                                            .addGroup(PanelChecksLayout.createSequentialGroup()
                                                .addComponent(txtPrecioUnitarioBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(txtPrecioUnitarioCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(txtPrecioUnitarioCopiaSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(130, 130, 130)
                                                .addComponent(txtPrecioUnitarioFotocopias, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioUnitarioTramiteAdministrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioUnitarioRegularizacionEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioUnitarioTramiteRegistrosPublicos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(6, 6, 6)))
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelMetric26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioUnitarioAnotacionMarginal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelMetric25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioUnitarioPeritaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelMetric24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecioUnitarioOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelChecksLayout.createSequentialGroup()
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantidadBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkCalificacion)
                                    .addComponent(txtCantidadCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkTestimonio)
                                    .addComponent(txtCantidadTestimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkCopiaSimple)
                                    .addComponent(txtCantidadCopiaSimple, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkCopiaCertificada)
                                    .addComponent(txtCantidadCopiaCertificada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkCCPartidas)
                                    .addComponent(txtCantidadCCPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkConstancia)
                                    .addComponent(txtCantidadConstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkExhibicion)
                                    .addComponent(txtCantidadExhibicion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkFotocopias)
                                    .addComponent(txtCantidadFotocopias, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkTramiteAdministrativo)
                                    .addComponent(txtCantidadTramiteAdministrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkRegularizacionEscritura)
                                    .addComponent(txtCantidadRegularizacionEscritura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkTramiteRegistrosPublicos)
                                    .addComponent(txtCantidadTramiteRegistrosPublicos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkAnotacionMarginal)
                                    .addComponent(txtCantidadAnotacionMarginal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkPeritaje)
                                    .addComponent(txtCantidadPeritaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidadOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        PanelTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        PanelTotal.setColorPrimario(new java.awt.Color(0, 0, 0));

        labelHeader1.setBackground(new java.awt.Color(0, 0, 0));
        labelHeader1.setText("TOTAL");
        labelHeader1.setColor(new java.awt.Color(0, 102, 153));
        labelHeader1.setColored(true);
        labelHeader1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelHeader1.setMaximumSize(new java.awt.Dimension(466, 25));
        labelHeader1.setMinimumSize(new java.awt.Dimension(466, 25));
        labelHeader1.setOpaque(true);
        labelHeader1.setPreferredSize(new java.awt.Dimension(466, 25));

        labelMetric39.setText("S/.");
        labelMetric39.setColorDeSombra(new java.awt.Color(0, 102, 153));
        labelMetric39.setDistanciaDeSombra(2);
        labelMetric39.setMaximumSize(new java.awt.Dimension(17, 25));
        labelMetric39.setMinimumSize(new java.awt.Dimension(17, 25));
        labelMetric39.setPreferredSize(new java.awt.Dimension(17, 25));

        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        txtTotal.setText("0.0");
        txtTotal.setColor(new java.awt.Color(255, 102, 102));
        txtTotal.setColored(true);
        txtTotal.setIconTextGap(1);
        txtTotal.setMaximumSize(new java.awt.Dimension(79, 25));
        txtTotal.setMinimumSize(new java.awt.Dimension(79, 25));
        txtTotal.setOpaque(true);
        txtTotal.setPreferredSize(new java.awt.Dimension(79, 25));

        javax.swing.GroupLayout PanelTotalLayout = new javax.swing.GroupLayout(PanelTotal);
        PanelTotal.setLayout(PanelTotalLayout);
        PanelTotalLayout.setHorizontalGroup(
            PanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMetric39, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTotalLayout.setVerticalGroup(
            PanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMetric39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelChecks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(PanelBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(PanelChecks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(panelImage1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void chkBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBusquedaActionPerformed
        if(this.chkBusqueda.isSelected())
        {

            this.chkBusqueda.setSelected(true);
            this.txtCantidadBusqueda.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 1;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioBusqueda.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadBusqueda.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioBusqueda.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalBusqueda.setText(rpta+"");

            SumaTotal();
        }
        else{

            this.txtCantidadBusqueda.setText("");
            this.txtPrecioUnitarioBusqueda.setText("");
            this.txtTotalBusqueda.setText(0+"");
            SumaTotal();

        }
    }//GEN-LAST:event_chkBusquedaActionPerformed

    private void chkCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCalificacionActionPerformed

        if(this.chkCalificacion.isSelected())
        {

            this.chkCalificacion.setSelected(true);
            this.txtCantidadCalificacion.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 2;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioCalificacion.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadCalificacion.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioCalificacion.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalCalificacion.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadCalificacion.setText("");
            this.txtPrecioUnitarioCalificacion.setText("");
            this.txtTotalCalificacion.setText(0+"");
            this.SumaTotal();

        }
    }//GEN-LAST:event_chkCalificacionActionPerformed

    private void chkTestimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTestimonioActionPerformed
        if(this.chkTestimonio.isSelected())
        {

            this.chkTestimonio.setSelected(true);
            this.txtCantidadTestimonio.requestFocus();
            this.txtCantidadTestimonio.selectAll();
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 3;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioTestimonio.setText(costo);

            this.SumaTotal();
        }
        else{

            this.txtCantidadTestimonio.setText("");
            this.txtPrecioUnitarioTestimonio.setText("");
            this.txtTotalTestimonio.setText(0+"");
            this.SumaTotal();

        }
    }//GEN-LAST:event_chkTestimonioActionPerformed

    private void chkCopiaSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCopiaSimpleActionPerformed

        if(this.chkCopiaSimple.isSelected())
        {

            this.chkCopiaSimple.setSelected(true);
            this.txtCantidadCopiaSimple.requestFocus();
            this.txtCantidadCopiaSimple.selectAll();
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 4;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioCopiaSimple.setText(costo);

            this.SumaTotal();
        }
        else{

            this.txtCantidadCopiaSimple.setText("");
            this.txtPrecioUnitarioCopiaSimple.setText("");
            this.txtTotalCopiaSimple.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkCopiaSimpleActionPerformed

    private void chkCopiaCertificadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCopiaCertificadaActionPerformed

        if(this.chkCopiaCertificada.isSelected())
        {

            this.chkCopiaCertificada.setSelected(true);
            this.txtCantidadCopiaCertificada.requestFocus();
            this.txtCantidadCopiaCertificada.selectAll();
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 6;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioCopiaCertificada.setText(costo);

            this.SumaTotal();
        }
        else{

            this.txtCantidadCopiaCertificada.setText("");
            this.txtPrecioUnitarioCopiaCertificada.setText("");
            this.txtTotalCopiaCertificada.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkCopiaCertificadaActionPerformed

    private void chkCCPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCCPartidasActionPerformed
        if(this.chkCCPartidas.isSelected())
        {

            this.chkCCPartidas.setSelected(true);
            this.txtCantidadCCPartidas.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 16;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioCCPartidas.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadCCPartidas.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioCCPartidas.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalCCPartidas.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadCCPartidas.setText("");
            this.txtPrecioUnitarioCCPartidas.setText("");
            this.txtTotalCCPartidas.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkCCPartidasActionPerformed

    private void chkConstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkConstanciaActionPerformed
        if(this.chkConstancia.isSelected())
        {

            this.chkConstancia.setSelected(true);
            this.txtCantidadConstancia.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 7;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioConstancia.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadConstancia.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioConstancia.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalConstancia.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadConstancia.setText("");
            this.txtPrecioUnitarioConstancia.setText("");
            this.txtTotalConstancia.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkConstanciaActionPerformed

    private void chkExhibicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkExhibicionActionPerformed
        if(this.chkExhibicion.isSelected())
        {

            this.chkExhibicion.setSelected(true);
            this.txtCantidadExhibicion.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 8;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioExhibicion.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadExhibicion.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioExhibicion.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalExhibicion.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadExhibicion.setText("");
            this.txtPrecioUnitarioExhibicion.setText("");
            this.txtTotalExhibicion.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkExhibicionActionPerformed

    private void chkFotocopiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFotocopiasActionPerformed
        if(this.chkFotocopias.isSelected())
        {

            this.chkFotocopias.setSelected(true);
            this.txtCantidadFotocopias.requestFocus();
            this.txtCantidadFotocopias.selectAll();
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 9;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioFotocopias.setText(costo);

            this.SumaTotal();
        }
        else{

            this.txtCantidadFotocopias.setText("");
            this.txtPrecioUnitarioFotocopias.setText("");
            this.txtTotalFotocopias.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkFotocopiasActionPerformed

    private void chkTramiteAdministrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTramiteAdministrativoActionPerformed
        if(this.chkTramiteAdministrativo.isSelected())
        {

            this.chkTramiteAdministrativo.setSelected(true);
            this.txtCantidadTramiteAdministrativo.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 10;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioTramiteAdministrativo.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadTramiteAdministrativo.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioTramiteAdministrativo.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalTramiteAdministrativo.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadTramiteAdministrativo.setText("");
            this.txtPrecioUnitarioTramiteAdministrativo.setText("");
            this.txtTotalTramiteAdministrativo.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkTramiteAdministrativoActionPerformed

    private void chkRegularizacionEscrituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRegularizacionEscrituraActionPerformed
        if(this.chkRegularizacionEscritura.isSelected())
        {

            this.chkRegularizacionEscritura.setSelected(true);
            this.txtCantidadRegularizacionEscritura.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 11;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioRegularizacionEscritura.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadRegularizacionEscritura.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioRegularizacionEscritura.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalRegularizacionEscritura.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadRegularizacionEscritura.setText("");
            this.txtPrecioUnitarioRegularizacionEscritura.setText("");
            this.txtTotalRegularizacionEscritura.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkRegularizacionEscrituraActionPerformed

    private void chkTramiteRegistrosPublicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTramiteRegistrosPublicosActionPerformed
        if(this.chkTramiteRegistrosPublicos.isSelected())
        {

            this.chkTramiteRegistrosPublicos.setSelected(true);
            this.txtCantidadTramiteRegistrosPublicos.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 12;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioTramiteRegistrosPublicos.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadTramiteRegistrosPublicos.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioTramiteRegistrosPublicos.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalTramiteRegistrosPublicos.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadTramiteRegistrosPublicos.setText("");
            this.txtPrecioUnitarioTramiteRegistrosPublicos.setText("");
            this.txtTotalTramiteRegistrosPublicos.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkTramiteRegistrosPublicosActionPerformed

    private void chkAnotacionMarginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAnotacionMarginalActionPerformed
        if(this.chkAnotacionMarginal.isSelected())
        {

            this.chkAnotacionMarginal.setSelected(true);
            this.txtCantidadAnotacionMarginal.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 13;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioAnotacionMarginal.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadAnotacionMarginal.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioAnotacionMarginal.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalAnotacionMarginal.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadAnotacionMarginal.setText("");
            this.txtPrecioUnitarioAnotacionMarginal.setText("");
            this.txtTotalAnotacionMarginal.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkAnotacionMarginalActionPerformed

    private void chkOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOtrosActionPerformed
        if(this.chkOtros.isSelected())
        {
            this.txtOtros.requestFocus();
            this.chkOtros.setSelected(true);
            this.txtCantidadOtros.setText(0+"");

            this.txtPrecioUnitarioOtros.setText(0+"");
            int cantidad = Integer.parseInt(this.txtCantidadOtros.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioOtros.getText());

            double total = this.HallarTotal(cantidad, precio);
            this.txtTotalOtros.setText(total+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadOtros.setText("");
            this.txtPrecioUnitarioOtros.setText("");
            this.txtTotalOtros.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkOtrosActionPerformed

    private void txtOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtrosActionPerformed

    private void txtCantidadCalificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCalificacionKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadCalificacion.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioCalificacion.getText());

        double total = this.HallarTotal(cantidad, precio);
        this.txtTotalCalificacion.setText(total+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadCalificacionKeyPressed

    private void txtCantidadBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadBusquedaActionPerformed

    }//GEN-LAST:event_txtCantidadBusquedaActionPerformed

    private void txtCantidadBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadBusquedaKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadBusqueda.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioBusqueda.getText());

        double total = this.HallarTotal(cantidad, precio);
        this.txtTotalBusqueda.setText(total+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadBusquedaKeyPressed

    private void txtCantidadTestimonioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadTestimonioKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadTestimonio.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioTestimonio.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalTestimonio.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadTestimonioKeyPressed

    private void txtCantidadCopiaSimpleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCopiaSimpleKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadCopiaSimple.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioCopiaSimple.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalCopiaSimple.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadCopiaSimpleKeyPressed

    private void txtCantidadCopiaCertificadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCopiaCertificadaKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadCopiaCertificada.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioCopiaCertificada.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalCopiaCertificada.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadCopiaCertificadaKeyPressed

    private void txtCantidadCCPartidasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCCPartidasKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadCCPartidas.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioCCPartidas.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalCCPartidas.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadCCPartidasKeyPressed

    private void txtCantidadConstanciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadConstanciaKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadConstancia.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioConstancia.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalConstancia.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadConstanciaKeyPressed

    private void txtCantidadExhibicionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadExhibicionKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadExhibicion.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioExhibicion.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalExhibicion.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadExhibicionKeyPressed

    private void txtCantidadFotocopiasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadFotocopiasKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadFotocopias.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioFotocopias.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalFotocopias.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadFotocopiasKeyPressed

    private void txtCantidadTramiteAdministrativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadTramiteAdministrativoKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadTramiteAdministrativo.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioTramiteAdministrativo.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalTramiteAdministrativo.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadTramiteAdministrativoKeyPressed

    private void txtCantidadRegularizacionEscrituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadRegularizacionEscrituraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadRegularizacionEscrituraActionPerformed

    private void txtCantidadRegularizacionEscrituraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadRegularizacionEscrituraKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadRegularizacionEscritura.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioRegularizacionEscritura.getText());

        double total = this.HallarTotal(cantidad, precio);
        this.txtTotalRegularizacionEscritura.setText(total+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadRegularizacionEscrituraKeyPressed

    private void txtCantidadTramiteRegistrosPublicosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadTramiteRegistrosPublicosKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadTramiteRegistrosPublicos.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioTramiteRegistrosPublicos.getText());

        double total = this.HallarTotal(cantidad, precio);
        this.txtTotalTramiteRegistrosPublicos.setText(total+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadTramiteRegistrosPublicosKeyPressed

    private void txtCantidadAnotacionMarginalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadAnotacionMarginalKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadAnotacionMarginal.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioAnotacionMarginal.getText());

        double total = this.HallarTotal(cantidad, precio);
        this.txtTotalAnotacionMarginal.setText(total+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadAnotacionMarginalKeyPressed

    private void txtCantidadPeritajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadPeritajeKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadPeritaje.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioPeritaje.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalPeritaje.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadPeritajeKeyPressed

    private void txtPrecioUnitarioPeritajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioPeritajeKeyPressed

    }//GEN-LAST:event_txtPrecioUnitarioPeritajeKeyPressed

    private void btnBuscarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSolicitudActionPerformed
        String codigoUsuario=null, nombre = null;
        String numeroSolicitud = this.txtNumSolicitud.getText();
        try{
            con.conectar();
            ResultSet res=con.consulta("SELECT codUsu, codTipSol, idSol from solicitudes where codSol = "+ numeroSolicitud +";");
            res.next();
            codigoUsuario = res.getString(1);
            ResultSet res1=con.consulta("select concat(nombre, ' ', apePat, ' ', apeMat) as nombre from usuarios where codUsu = "+codigoUsuario +";");
            res1.next();
            nombre = res1.getString(1);
            //JOptionPane.showMessageDialog(rootPane, "nombre: "+nombre);
            this.txtNombreUsuario.setText(nombre);
            con.cierraConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, "Error de consulta" + e.getMessage());
        }
        this.lblcodUsu.setText(codigoUsuario+"");
    }//GEN-LAST:event_btnBuscarSolicitudActionPerformed

    private void chkPeritajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPeritajeActionPerformed
        if(this.chkPeritaje.isSelected())
        {

            this.chkPeritaje.setSelected(true);
            this.txtCantidadPeritaje.setText(1+"");
            try{
                con.conectar();
                ResultSet res=con.consulta("SELECT costo FROM tupa WHERE codTupa = 5;");
                res.next();
                costo=res.getString(1);
                con.cierraConexion();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e + "mal2");
            }
            this.txtPrecioUnitarioPeritaje.setText(costo);
            int cantidad = Integer.parseInt(this.txtCantidadPeritaje.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioPeritaje.getText());

            double total = this.HallarTotal(cantidad, precio);
            float rpta = (float) (Math.rint(total*100)/100);
            this.txtTotalPeritaje.setText(rpta+"");

            this.SumaTotal();
        }
        else{

            this.txtCantidadPeritaje.setText("");
            this.txtPrecioUnitarioPeritaje.setText("");
            this.txtTotalPeritaje.setText(0+"");
            this.SumaTotal();
        }
    }//GEN-LAST:event_chkPeritajeActionPerformed

    private void txtCantidadOtrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadOtrosKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadOtros.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioOtros.getText());

        double total = this.HallarTotal(cantidad, precio);
        this.txtTotalOtros.setText(total+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtCantidadOtrosKeyPressed

    private void txtPrecioUnitarioOtrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioOtrosKeyPressed
        int cantidad = Integer.parseInt(this.txtCantidadOtros.getText());
        double precio = Double.parseDouble(this.txtPrecioUnitarioOtros.getText());

        double total = this.HallarTotal(cantidad, precio);
        float rpta = (float) (Math.rint(total*100)/100);
        this.txtTotalOtros.setText(rpta+"");
        this.SumaTotal();
    }//GEN-LAST:event_txtPrecioUnitarioOtrosKeyPressed

    private void txtNumSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSolicitudActionPerformed

    private void txtNumSolicitudKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSolicitudKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            btnBuscarSolicitud.doClick();
        }
    }//GEN-LAST:event_txtNumSolicitudKeyPressed

    private void txtNumSolicitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSolicitudKeyReleased
        if(txtNumSolicitud.getText().length()>3){
            btnBuscarSolicitud.doClick();
        }
    }//GEN-LAST:event_txtNumSolicitudKeyReleased

    private void txtNumSolicitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSolicitudKeyTyped
        int n = (int)evt.getKeyChar();
        if(n>=48 && n<=57 || n==13 || n==127){

        }else{
            evt.setKeyChar((char)KeyEvent.VK_CLEAR);
        }
        btnNuevo.setForeground(new Color(255,255,255));
        btnNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnBuscarSolicitud.setForeground(new Color(255,255,255));
        btnBuscarSolicitud.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png")));
        btnCancelar.setForeground(new Color(255,255,255));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setForeground(new Color(255,255,255));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setForeground(new Color(255,255,255));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setForeground(new Color(255,255,255));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_txtNumSolicitudKeyTyped

    private void btnNuevoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseReleased
        btnNuevo.setForeground(new Color(0,153,255));
        btnNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,153,255)));
        btnBuscarSolicitud.setForeground(new Color(255,255,255));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png")));
        btnCancelar.setForeground(new Color(255,255,255));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setForeground(new Color(255,255,255));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setForeground(new Color(255,255,255));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setForeground(new Color(255,255,255));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnNuevoMouseReleased

    private void btnNuevoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseMoved
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        
    }//GEN-LAST:event_btnNuevoMouseMoved

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        activa();
        this.btnImprimir.setEnabled(false);
        try{
            con.conectar();
            ResultSet res=con.consulta("SELECT max(numRec) FROM recibo;");
            res.next();
            numeroRecibo=Integer.parseInt(res.getString(1));

            con.cierraConexion();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        nextNumero = numeroRecibo + 1;
        this.lblNumeroRecibo.setText(nextNumero+"");
        this.txtNumSolicitud.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseReleased
        btnCancelar.setForeground(new Color(255,0,0));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,0,0)));
        btnBuscarSolicitud.setForeground(new Color(255,255,255));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png")));
        btnNuevo.setForeground(new Color(255,255,255));
        btnNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setForeground(new Color(255,255,255));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setForeground(new Color(255,255,255));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setForeground(new Color(255,255,255));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnCancelarMouseReleased

    private void btnCancelarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseMoved
         btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnCancelarMouseMoved

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.lblNumeroRecibo.setText("");
        desactiva();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
        btnGuardar.setForeground(new Color(0,204,51));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,204,51)));
        btnBuscarSolicitud.setForeground(new Color(255,255,255));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png")));
        btnCancelar.setForeground(new Color(255,255,255));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnNuevo.setForeground(new Color(255,255,255));
        btnNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setForeground(new Color(255,255,255));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setForeground(new Color(255,255,255));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnGuardarMouseReleased

    private void btnGuardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseMoved
         btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnGuardarMouseMoved

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        /*
        *******************************************************************************************
        *  Esta parte sirve para guardar en la tabla Recibo, todos los campos requidos por la tabla
        *  pero tambien, se efectua una consulta para recuperar el ultimo dato de la tabla recibos
        *  con el fin de que ese valor se pueda repetir la cantidad de veces necesarias para que se
        *  guarde en la tabla "detallerecibo".
        ********************************************************************************************
        */
        int last_cod =0;
        String numerosolicitud = this.txtNumSolicitud.getText();

        double total = Double.parseDouble(this.txtTotal.getText());
        int codPersonal =  1101;
        int codUsuario = Integer.parseInt(this.lblcodUsu.getText());
        try{
            con.conectar();
            //Conectarse a la Base de Datos y ejecutar los SQL
            con.insertar("INSERT INTO recibo (numRec, numSol, total,fecha,hora,anulado,codPer,codUsu,numDNI) VALUES (null,'"+numerosolicitud+"',"+total+",now(),now(),0,"+codPersonal+","+codUsuario+",0);");

            ResultSet res1=con.consulta("select numRec from recibo order by numRec desc limit 0,1;");
            res1.next();
            last_cod = Integer.parseInt(res1.getString(1));

            con.cierraConexion();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        /*
        ************************************************************************
        **    fin de la Priemra parte de la consulta
        ***********************************************************************
        */

        /*
        **********************************************************************
        *   Verificando la activacion de los chekc de cada uno e insertando
        *   los valores segun corresponda
        **********************************************************************
        */

        if (this.chkBusqueda.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkBusqueda.getText();
            double cantidad = Double.parseDouble(this.txtCantidadBusqueda.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioBusqueda.getText());
            double subtotal = Double.parseDouble(this.txtTotalBusqueda.getText());
            try {
                con.conectar();
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRecSolicitud.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (this.chkCalificacion.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkCalificacion.getText();
            double cantidad = Double.parseDouble(this.txtCantidadCalificacion.getText());
            double precio = Double.parseDouble(this.txtPrecioUnitarioCalificacion.getText());
            double subtotal = Double.parseDouble(this.txtTotalCalificacion.getText());
            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkTestimonio.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkTestimonio.getText();
            double cantidad = Double.parseDouble(this.txtCantidadTestimonio.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioTestimonio.getText());
            double subtotal = Double.parseDouble(this.txtTotalTestimonio.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkCopiaSimple.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkCopiaSimple.getText();
            double cantidad = Double.parseDouble(this.txtCantidadCopiaSimple.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioCopiaSimple.getText());
            double subtotal = Double.parseDouble(this.txtTotalCopiaSimple.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkCopiaCertificada.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkCopiaCertificada.getText();
            double cantidad = Double.parseDouble(this.txtCantidadCopiaCertificada.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioCopiaCertificada.getText());
            double subtotal = Double.parseDouble(this.txtTotalCopiaCertificada.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkCCPartidas.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkCCPartidas.getText();
            double cantidad = Double.parseDouble(this.txtCantidadCCPartidas.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioCCPartidas.getText());
            double subtotal = Double.parseDouble(this.txtTotalCCPartidas.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkConstancia.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkConstancia.getText();
            double cantidad = Double.parseDouble(this.txtCantidadConstancia.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioConstancia.getText());
            double subtotal = Double.parseDouble(this.txtTotalConstancia.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkExhibicion.isSelected())
        {
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkExhibicion.getText();
            double cantidad = Double.parseDouble(this.txtCantidadExhibicion.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioExhibicion.getText());
            double subtotal = Double.parseDouble(this.txtTotalExhibicion.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkFotocopias.isSelected())
        {
            JOptionPane.showMessageDialog(rootPane, "Fotocopia");
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkFotocopias.getText();
            double cantidad = Double.parseDouble(this.txtCantidadFotocopias.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioFotocopias.getText());
            double subtotal = Double.parseDouble(this.txtTotalFotocopias.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkTramiteAdministrativo.isSelected())
        {
            JOptionPane.showMessageDialog(rootPane, "Tramite Administrativo");
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkTramiteAdministrativo.getText();
            double cantidad = Double.parseDouble(this.txtCantidadTramiteAdministrativo.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioTramiteAdministrativo.getText());
            double subtotal = Double.parseDouble(this.txtTotalTramiteAdministrativo.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkRegularizacionEscritura.isSelected())
        {
            JOptionPane.showMessageDialog(rootPane, "Regularizacion de Escrituras");
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkRegularizacionEscritura.getText();
            double cantidad = Double.parseDouble(this.txtCantidadRegularizacionEscritura.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioRegularizacionEscritura.getText());
            double subtotal = Double.parseDouble(this.txtTotalRegularizacionEscritura.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkTramiteRegistrosPublicos.isSelected())
        {
            JOptionPane.showMessageDialog(rootPane, "Tramite ");
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkTramiteRegistrosPublicos.getText();
            double cantidad = Double.parseDouble(this.txtCantidadTramiteRegistrosPublicos.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioTramiteRegistrosPublicos.getText());
            double subtotal = Double.parseDouble(this.txtTotalTramiteRegistrosPublicos.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkAnotacionMarginal.isSelected())
        {
            JOptionPane.showMessageDialog(rootPane, "activo");
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.chkAnotacionMarginal.getText();
            double cantidad = Double.parseDouble(this.txtCantidadAnotacionMarginal.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioAnotacionMarginal.getText());
            double subtotal = Double.parseDouble(this.txtTotalAnotacionMarginal.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }
        if (this.chkOtros.isSelected())
        {
            JOptionPane.showMessageDialog(rootPane, "activo");
            // Declarando variables y capturando valores de cada line en el recibo
            String concepto = this.txtOtros.getText();

            double cantidad = Double.parseDouble(this.txtCantidadOtros.getText());
            double precio   = Double.parseDouble(this.txtPrecioUnitarioOtros.getText());
            double subtotal = Double.parseDouble(this.txtTotalOtros.getText());

            /*
            *  Aqui se guarda la informacion en la Tabla DetalleRecibo
            */
            try{
                con.conectar();
                //Conectarse a la Base de Datos y ejecutar los SQL
                con.insertar("INSERT INTO recepcion.detallerecibo (codDetRec,numRecibo,concepto,cantidad,pUnitario,subtotal,fecha) VALUES (null,"+last_cod+",'"+concepto+"',"+cantidad+","+precio+","+subtotal+",now());");
                con.cierraConexion();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }

            /*
            ****************************************************************
            *   FIN DEL SCRIPT
            ****************************************************************
            */
        }

        this.btnImprimir.setEnabled(true);
        this.btnGuardar.setEnabled(false);      
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnImprimirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseReleased
        btnImprimir.setForeground(new Color(255,204,51));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,204,51)));
        btnBuscarSolicitud.setForeground(new Color(255,255,255));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png")));
        btnCancelar.setForeground(new Color(255,255,255));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setForeground(new Color(255,255,255));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnNuevo.setForeground(new Color(255,255,255));
        btnNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setForeground(new Color(255,255,255));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnImprimirMouseReleased

    private void btnImprimirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseMoved
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnImprimirMouseMoved

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    String numeroRecibo = this.lblNumeroRecibo.getText();
        jasper.ejecutarReporte(numeroRecibo);
        
        desactiva();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnReImprimirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReImprimirMouseReleased
        btnReImprimir.setForeground(new Color(255,255,153));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,153)));
        btnBuscarSolicitud.setForeground(new Color(255,255,255));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png")));
        btnCancelar.setForeground(new Color(255,255,255));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setForeground(new Color(255,255,255));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setForeground(new Color(255,255,255));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnNuevo.setForeground(new Color(255,255,255));
        btnNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnReImprimirMouseReleased

    private void btnReImprimirMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReImprimirMouseMoved
         btnReImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        btnGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnReImprimirMouseMoved

    private void btnReImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReImprimirActionPerformed
       String numeroRecibo = JOptionPane.showInputDialog("Escriba el Numero de Solicitud");
        jasper.ejecutarReporte(numeroRecibo);
    }//GEN-LAST:event_btnReImprimirActionPerformed

    private void btnBuscarSolicitudMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarSolicitudMouseReleased
       btnBuscarSolicitud.setForeground(new Color(153,204,0));
       btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarverde.png")));
       btnBuscarSolicitud.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153,204,0)));
        btnCancelar.setForeground(new Color(255,255,255));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setForeground(new Color(255,255,255));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setForeground(new Color(255,255,255));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setForeground(new Color(255,255,255));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_btnBuscarSolicitudMouseReleased

    private void PanelBusquedaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelBusquedaMouseMoved
       btnBuscarSolicitud.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51)));
    }//GEN-LAST:event_PanelBusquedaMouseMoved

    private void btnBuscarSolicitudMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarSolicitudMouseMoved
       btnBuscarSolicitud.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153,204,0)));
    }//GEN-LAST:event_btnBuscarSolicitudMouseMoved

    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        String text2 = this.txtEfectivo.getText();

        int resultado= text2.indexOf('.');
        if(resultado != -1)
        {
            if("".equals(this.txtTotal.getText()))
            {
                JOptionPane.showMessageDialog(rootPane, "El total esta en CERO 0");
                this.txtEfectivo.setText("");
                this.txtTotal.setBackground(Color.yellow);
            }else
            {

                this.txtTotal.setBackground(Color.white);

                double z;
                z = Double.parseDouble(this.txtEfectivo.getText());
                double y;
                y = Double.parseDouble(this.txtTotal.getText());
                double resta = z-y;

                float rpta = (float) (Math.rint(resta*10)/10);
                
                if(resta < 0){
                    JOptionPane.showMessageDialog(rootPane, "Algo esta mal");
                }else{
                this.lbCambia.setText(rpta+"");

                this.btnGuardar.setEnabled(true);
                }
            }

        }else{
            this.btnGuardar.setEnabled(false);
            this.lbCambia.setText("");
        }
        
        ///
        btnNuevo.setForeground(new Color(255,255,255));
        btnNuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnBuscarSolicitud.setForeground(new Color(255,255,255));
        btnBuscarSolicitud.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarazul.png")));
        btnCancelar.setForeground(new Color(255,255,255));
        btnCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnGuardar.setForeground(new Color(255,255,255));
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnImprimir.setForeground(new Color(255,255,255));
        btnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
        btnReImprimir.setForeground(new Color(255,255,255));
        btnReImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51,51,51)));
    }//GEN-LAST:event_txtEfectivoKeyTyped

    private void chkBusquedaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkBusquedaMouseMoved
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkBusquedaMouseMoved

    private void chkCalificacionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkCalificacionMouseMoved
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkCalificacionMouseMoved

    private void chkTestimonioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTestimonioMouseMoved
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkTestimonioMouseMoved

    private void chkCopiaSimpleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkCopiaSimpleMouseMoved
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkCopiaSimpleMouseMoved

    private void chkCopiaCertificadaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkCopiaCertificadaMouseMoved
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkCopiaCertificadaMouseMoved

    private void chkCCPartidasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkCCPartidasMouseMoved
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkCCPartidasMouseMoved

    private void chkConstanciaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkConstanciaMouseMoved
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkConstanciaMouseMoved

    private void chkExhibicionMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkExhibicionMouseMoved
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkExhibicionMouseMoved

    private void chkFotocopiasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkFotocopiasMouseMoved
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkFotocopiasMouseMoved

    private void chkTramiteAdministrativoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTramiteAdministrativoMouseMoved
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkTramiteAdministrativoMouseMoved

    private void chkRegularizacionEscrituraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkRegularizacionEscrituraMouseMoved
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkRegularizacionEscrituraMouseMoved

    private void chkTramiteRegistrosPublicosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTramiteRegistrosPublicosMouseMoved
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkTramiteRegistrosPublicosMouseMoved

    private void chkAnotacionMarginalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkAnotacionMarginalMouseMoved
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkAnotacionMarginalMouseMoved

    private void chkPeritajeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkPeritajeMouseMoved
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_chkPeritajeMouseMoved

    private void txtOtrosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtOtrosMouseMoved
        txtTotalOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtCantidadOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        txtPrecioUnitarioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,153,0)));
        //
        txtTotalCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCalificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTestimonio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaSimple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCopiaCertificada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioCCPartidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioConstancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioExhibicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioFotocopias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteAdministrativo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioRegularizacionEscritura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioTramiteRegistrosPublicos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioAnotacionMarginal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioPeritaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        //
        txtTotalBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,102,102)));
        txtCantidadBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
        txtPrecioUnitarioBusqueda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,255)));
    }//GEN-LAST:event_txtOtrosMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.label.LabelMetric LblDebo;
    private org.edisoncor.gui.label.LabelMetric LblTengo;
    private org.edisoncor.gui.panel.Panel PanelBusqueda;
    private org.edisoncor.gui.panel.Panel PanelChecks;
    private org.edisoncor.gui.panel.Panel PanelOpciones;
    private org.edisoncor.gui.panel.Panel PanelTotal;
    private javax.swing.JButton btnBuscarSolicitud;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReImprimir;
    private javax.swing.JCheckBox chkAnotacionMarginal;
    private javax.swing.JCheckBox chkBusqueda;
    private javax.swing.JCheckBox chkCCPartidas;
    private javax.swing.JCheckBox chkCalificacion;
    private javax.swing.JCheckBox chkConstancia;
    private javax.swing.JCheckBox chkCopiaCertificada;
    private javax.swing.JCheckBox chkCopiaSimple;
    private javax.swing.JCheckBox chkExhibicion;
    private javax.swing.JCheckBox chkFotocopias;
    private javax.swing.JCheckBox chkOtros;
    private javax.swing.JCheckBox chkPeritaje;
    private javax.swing.JCheckBox chkRegularizacionEscritura;
    private javax.swing.JCheckBox chkTestimonio;
    private javax.swing.JCheckBox chkTramiteAdministrativo;
    private javax.swing.JCheckBox chkTramiteRegistrosPublicos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator8;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private org.edisoncor.gui.label.LabelMetric labelMetric10;
    private org.edisoncor.gui.label.LabelMetric labelMetric11;
    private org.edisoncor.gui.label.LabelMetric labelMetric12;
    private org.edisoncor.gui.label.LabelMetric labelMetric13;
    private org.edisoncor.gui.label.LabelMetric labelMetric14;
    private org.edisoncor.gui.label.LabelMetric labelMetric15;
    private org.edisoncor.gui.label.LabelMetric labelMetric16;
    private org.edisoncor.gui.label.LabelMetric labelMetric17;
    private org.edisoncor.gui.label.LabelMetric labelMetric18;
    private org.edisoncor.gui.label.LabelMetric labelMetric19;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric20;
    private org.edisoncor.gui.label.LabelMetric labelMetric21;
    private org.edisoncor.gui.label.LabelMetric labelMetric22;
    private org.edisoncor.gui.label.LabelMetric labelMetric23;
    private org.edisoncor.gui.label.LabelMetric labelMetric24;
    private org.edisoncor.gui.label.LabelMetric labelMetric25;
    private org.edisoncor.gui.label.LabelMetric labelMetric26;
    private org.edisoncor.gui.label.LabelMetric labelMetric27;
    private org.edisoncor.gui.label.LabelMetric labelMetric28;
    private org.edisoncor.gui.label.LabelMetric labelMetric29;
    private org.edisoncor.gui.label.LabelMetric labelMetric3;
    private org.edisoncor.gui.label.LabelMetric labelMetric30;
    private org.edisoncor.gui.label.LabelMetric labelMetric31;
    private org.edisoncor.gui.label.LabelMetric labelMetric32;
    private org.edisoncor.gui.label.LabelMetric labelMetric33;
    private org.edisoncor.gui.label.LabelMetric labelMetric34;
    private org.edisoncor.gui.label.LabelMetric labelMetric35;
    private org.edisoncor.gui.label.LabelMetric labelMetric36;
    private org.edisoncor.gui.label.LabelMetric labelMetric37;
    private org.edisoncor.gui.label.LabelMetric labelMetric38;
    private org.edisoncor.gui.label.LabelMetric labelMetric39;
    private org.edisoncor.gui.label.LabelMetric labelMetric4;
    private org.edisoncor.gui.label.LabelMetric labelMetric40;
    private org.edisoncor.gui.label.LabelMetric labelMetric41;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric6;
    private org.edisoncor.gui.label.LabelMetric labelMetric7;
    private org.edisoncor.gui.label.LabelMetric labelMetric8;
    private org.edisoncor.gui.label.LabelMetric labelMetric9;
    private javax.swing.JTextField lbCambia;
    private org.edisoncor.gui.label.LabelMetric lblNumeroRecibo;
    private javax.swing.JLabel lblcodUsu;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTextField txtCantidadAnotacionMarginal;
    private javax.swing.JTextField txtCantidadBusqueda;
    private javax.swing.JTextField txtCantidadCCPartidas;
    private javax.swing.JTextField txtCantidadCalificacion;
    private javax.swing.JTextField txtCantidadConstancia;
    private javax.swing.JTextField txtCantidadCopiaCertificada;
    private javax.swing.JTextField txtCantidadCopiaSimple;
    private javax.swing.JTextField txtCantidadExhibicion;
    private javax.swing.JTextField txtCantidadFotocopias;
    private javax.swing.JTextField txtCantidadOtros;
    private javax.swing.JTextField txtCantidadPeritaje;
    private javax.swing.JTextField txtCantidadRegularizacionEscritura;
    private javax.swing.JTextField txtCantidadTestimonio;
    private javax.swing.JTextField txtCantidadTramiteAdministrativo;
    private javax.swing.JTextField txtCantidadTramiteRegistrosPublicos;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNumSolicitud;
    private javax.swing.JTextField txtOtros;
    private javax.swing.JTextField txtPrecioUnitarioAnotacionMarginal;
    private javax.swing.JTextField txtPrecioUnitarioBusqueda;
    private javax.swing.JTextField txtPrecioUnitarioCCPartidas;
    private javax.swing.JTextField txtPrecioUnitarioCalificacion;
    private javax.swing.JTextField txtPrecioUnitarioConstancia;
    private javax.swing.JTextField txtPrecioUnitarioCopiaCertificada;
    private javax.swing.JTextField txtPrecioUnitarioCopiaSimple;
    private javax.swing.JTextField txtPrecioUnitarioExhibicion;
    private javax.swing.JTextField txtPrecioUnitarioFotocopias;
    private javax.swing.JTextField txtPrecioUnitarioOtros;
    private javax.swing.JTextField txtPrecioUnitarioPeritaje;
    private javax.swing.JTextField txtPrecioUnitarioRegularizacionEscritura;
    private javax.swing.JTextField txtPrecioUnitarioTestimonio;
    private javax.swing.JTextField txtPrecioUnitarioTramiteAdministrativo;
    private javax.swing.JTextField txtPrecioUnitarioTramiteRegistrosPublicos;
    private org.edisoncor.gui.label.LabelHeader txtTotal;
    private org.edisoncor.gui.label.LabelMetric txtTotalAnotacionMarginal;
    private org.edisoncor.gui.label.LabelMetric txtTotalBusqueda;
    private org.edisoncor.gui.label.LabelMetric txtTotalCCPartidas;
    private org.edisoncor.gui.label.LabelMetric txtTotalCalificacion;
    private org.edisoncor.gui.label.LabelMetric txtTotalConstancia;
    private org.edisoncor.gui.label.LabelMetric txtTotalCopiaCertificada;
    private org.edisoncor.gui.label.LabelMetric txtTotalCopiaSimple;
    private org.edisoncor.gui.label.LabelMetric txtTotalExhibicion;
    private org.edisoncor.gui.label.LabelMetric txtTotalFotocopias;
    private org.edisoncor.gui.label.LabelMetric txtTotalOtros;
    private org.edisoncor.gui.label.LabelMetric txtTotalPeritaje;
    private org.edisoncor.gui.label.LabelMetric txtTotalRegularizacionEscritura;
    private org.edisoncor.gui.label.LabelMetric txtTotalTestimonio;
    private org.edisoncor.gui.label.LabelMetric txtTotalTramiteAdministrativo;
    private org.edisoncor.gui.label.LabelMetric txtTotalTramiteRegistrosPublicos;
    // End of variables declaration//GEN-END:variables
}
