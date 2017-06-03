/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlCategorias;
import Control.ControlPersona;
import Control.ControlProducto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1061785255
 */
public class GUIPrincipal extends javax.swing.JFrame {
    
    Object datosCliente[][] = null;
    Object datosProducto[][] = null;
    Object datosCategoria[][] = null;
    Object productosAgregados[][] =  new Object[100][5];
    DefaultTableModel dtm;
    DefaultComboBoxModel cbx;
    int i=0;

    String nombresColumnas[] = {"Codigo Producto", "Nombre", "Valor venta","Cantidad", "Categoría"};
   
  
    public void obtenerEmpleado(String codEmpleado){
        lblEmpleado.setText(codEmpleado);
        
    }
    
    public void AgregarProductos(){      
        ControlCategorias cc = new ControlCategorias();
        if(txtFactCodProducto.getText().length()>0 & txtFactNomProducto.getText().length()>0 && txtCantidad.getText().length()>0){
            if(rbtnMaximo.isSelected() || rbtnMinimo.isSelected()){
                if(rbtnMaximo.isSelected()){
                    productosAgregados[i][0] = datosProducto[0][0];
                    productosAgregados[i][1] = datosProducto[0][1];
                    productosAgregados[i][2] = datosProducto[0][4];                   
                    productosAgregados[i][3] = txtCantidad.getText(); 
                    datosCategoria = cc.consultarCategoriaCodigo((int) datosProducto[0][6]);
                    productosAgregados[i][4] = datosCategoria[0][1]; 
                    i++;
                }else{
                    if(rbtnMinimo.isSelected()){                      
                        productosAgregados[i][0] = datosProducto[0][0];
                        productosAgregados[i][1] = datosProducto[0][1];
                        productosAgregados[i][2] = datosProducto[0][7];                   
                        productosAgregados[i][3] = txtCantidad.getText();
                        datosCategoria = cc.consultarCategoriaCodigo((int) datosProducto[0][6]);
                        productosAgregados[i][4] = datosCategoria[0][1];    
                        i++;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Debe selecionar el tipo de valor");           
            }            
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos obligatorios (*)");
        }
    }    
    
    /**
     * Creates new form GUIPrincipal
     */
    public GUIPrincipal() {
        dtm = new DefaultTableModel(datosProducto, nombresColumnas);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        grpValor = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFactDocCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFactNomCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFactCodProducto = new javax.swing.JTextField();
        txtFactNomProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        gatitosh = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtPagoTotal = new javax.swing.JTextField();
        lblEmpleado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFactApeCliente = new javax.swing.JTextField();
        rbtnMaximo = new javax.swing.JRadioButton();
        rbtnMinimo = new javax.swing.JRadioButton();
        btnAgregarProd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        calenFechaVenta = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFacturacion = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        btnInventario = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        btncategorias = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(780, 500));
        setMinimumSize(new java.awt.Dimension(780, 500));
        setPreferredSize(new java.awt.Dimension(780, 500));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 0, 51));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        jPanel1.add(txtFactDocCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("Código:*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 100, -1));
        jPanel1.add(txtFactNomCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 200, -1));

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(51, 0, 102));
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 90, 30));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 710, 10));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Facturación");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, -1));

        jLabel4.setBackground(new java.awt.Color(51, 0, 51));
        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Cliente");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("Total:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Cantidad:*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        txtFactCodProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFactCodProductoKeyReleased(evt);
            }
        });
        jPanel1.add(txtFactCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 150, -1));

        txtFactNomProducto.setEditable(false);
        jPanel1.add(txtFactNomProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 410, -1));

        btnBuscarProducto.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnBuscarProducto.setForeground(new java.awt.Color(51, 0, 102));
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 90, 30));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 20, 60));

        jSeparator4.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 650, 10));

        jSeparator5.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 20, 60));

        jSeparator6.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 20, 190));

        jSeparator7.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 20, 180));

        jSeparator8.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 710, 10));

        jSeparator9.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 630, -1));

        tblProductos.setModel(dtm);
        gatitosh.setViewportView(tblProductos);

        jPanel1.add(gatitosh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 699, 90));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setText("Número Documento:*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtPagoTotal.setEditable(false);
        jPanel1.add(txtPagoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 140, -1));
        jPanel1.add(lblEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 100, 20));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setText("Nombre:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));
        jPanel1.add(txtFactApeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 190, -1));

        grpValor.add(rbtnMaximo);
        rbtnMaximo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        rbtnMaximo.setText("Valor Máximo");
        rbtnMaximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnMaximoMousePressed(evt);
            }
        });
        jPanel1.add(rbtnMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        grpValor.add(rbtnMinimo);
        rbtnMinimo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        rbtnMinimo.setText("Valor Mínimo");
        rbtnMinimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtnMinimoMousePressed(evt);
            }
        });
        jPanel1.add(rbtnMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        btnAgregarProd.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnAgregarProd.setForeground(new java.awt.Color(51, 0, 102));
        btnAgregarProd.setText("Agregar");
        btnAgregarProd.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 90, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 60, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel11.setText("Valor Unitario:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, -1, -1));
        jPanel1.add(txtValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 90, -1));
        jPanel1.add(calenFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 10, 110, -1));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setText("Fecha de Venta:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        mnuFacturacion.setText("Facturación ");
        mnuFacturacion.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jMenuBar1.add(mnuFacturacion);

        jMenu2.setText("Clientes");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jMenuBar1.add(jMenu2);

        btnInventario.setText("Inventario");
        btnInventario.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventarioMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnInventario);

        jMenu5.setText("Reportes");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Configuración");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        jMenuItem1.setText("Roles");
        jMenu6.add(jMenuItem1);

        jMenuItem2.setText("Empleados");
        jMenu6.add(jMenuItem2);

        btncategorias.setText("Categorías");
        btncategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncategoriasActionPerformed(evt);
            }
        });
        jMenu6.add(btncategorias);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Salir");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        ControlProducto cp = new ControlProducto();
        if(txtFactCodProducto.getText().length()>0){
            datosProducto = cp.consultarproductoCodigo(Integer.parseInt(txtFactCodProducto.getText()));
            if(datosProducto[0][0]==null){
                 JOptionPane.showMessageDialog(this, "El producto no existe");
                 txtFactCodProducto.setText("");
                 txtFactNomProducto.setText("");       
             }else{
                 txtFactCodProducto.setText(String.valueOf(datosProducto[0][0]));
                 txtFactNomProducto.setText((String) datosProducto[0][1]);
                 if(rbtnMaximo.isSelected()){
                    float valorUnitario = (float) datosProducto[0][4];              
                    txtValorUnitario.setText(String.valueOf(valorUnitario));                    
                 }else{
                     if(rbtnMinimo.isSelected()){
                        float valorUnitario = (float) datosProducto[0][7];              
                        txtValorUnitario.setText(String.valueOf(valorUnitario));                         
                     }
                 }
             }             
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese un parámetro de búsqueda");          
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void btnInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseClicked
        GUIProductos gp=new GUIProductos();
        this.setVisible(false);
        gp.setVisible(true);
    }//GEN-LAST:event_btnInventarioMouseClicked

    private void btncategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncategoriasActionPerformed
        GUICategorias gc=new GUICategorias();
        this.setVisible(false);
        gc.setVisible(true);
    }//GEN-LAST:event_btncategoriasActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
       ControlPersona cp = new ControlPersona();
       if(txtFactDocCliente.getText().length()>0 || txtFactNomCliente.getText().length()>0 || txtFactApeCliente.getText().length()>0){
            if(txtFactDocCliente.getText().length()>0 && txtFactNomCliente.getText().length()>0 && txtFactApeCliente.getText().length()>0){
                datosCliente = cp.consultarPersonaTodos(Integer.parseInt(txtFactDocCliente.getText()), 
                        txtFactNomCliente.getText(), txtFactApeCliente.getText());
            }else{
                if(txtFactDocCliente.getText().length()==0 && txtFactNomCliente.getText().length()>0 && txtFactApeCliente.getText().length()==0){
                    datosCliente = cp.consultarPersonaNombres(txtFactNomCliente.getText());
                }else{
                    if(txtFactDocCliente.getText().length()>0 && txtFactNomCliente.getText().length()==0 && txtFactApeCliente.getText().length()==0){
                        datosCliente = cp.consultarPersonaDocumento(Integer.parseInt(txtFactDocCliente.getText()));
                    }else{
                        if(txtFactDocCliente.getText().length()>0 && txtFactNomCliente.getText().length()>0 && txtFactApeCliente.getText().length()==0){
                            datosCliente = cp.consultarPersonaDocNombres(Integer.parseInt(txtFactDocCliente.getText()), txtFactNomCliente.getText());
                        }
                    }
                }
            }   
            if(datosCliente[0][0]==null){
                JOptionPane.showMessageDialog(this, "El cliente no existe");
                txtFactDocCliente.setText("");
                txtFactNomCliente.setText("");
                txtFactApeCliente.setText("");                
            }else{
                txtFactDocCliente.setText(String.valueOf(datosCliente[0][1]));
                txtFactNomCliente.setText((String) datosCliente[0][2]);
                txtFactApeCliente.setText((String) datosCliente[0][3]);
            } 
       }else{
            JOptionPane.showMessageDialog(this, "Ingrese un parámetro de búsqueda");           
       }
      

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdActionPerformed
        this.AgregarProductos();
        dtm = new DefaultTableModel(productosAgregados, nombresColumnas);
        tblProductos.setModel(dtm);
    }//GEN-LAST:event_btnAgregarProdActionPerformed

    private void rbtnMaximoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMaximoMousePressed
        if(txtFactNomProducto.getText().length()>0){
            float valorUnitario = (float) datosProducto[0][4];              
           txtValorUnitario.setText(String.valueOf(valorUnitario));
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
        }
    }//GEN-LAST:event_rbtnMaximoMousePressed

    private void txtFactCodProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFactCodProductoKeyReleased
        txtFactNomProducto.setText("");
        txtValorUnitario.setText("");
    }//GEN-LAST:event_txtFactCodProductoKeyReleased

    private void rbtnMinimoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnMinimoMousePressed
        if(txtFactNomProducto.getText().length()>0){
            float valorUnitario = (float) datosProducto[0][7];              
           txtValorUnitario.setText(String.valueOf(valorUnitario));
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un producto");
        }
    }//GEN-LAST:event_rbtnMinimoMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProd;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JMenu btnInventario;
    private javax.swing.JMenuItem btncategorias;
    private com.toedter.calendar.JDateChooser calenFechaVenta;
    private javax.swing.JScrollPane gatitosh;
    private javax.swing.ButtonGroup grpValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JMenu mnuFacturacion;
    private javax.swing.JRadioButton rbtnMaximo;
    private javax.swing.JRadioButton rbtnMinimo;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFactApeCliente;
    private javax.swing.JTextField txtFactCodProducto;
    private javax.swing.JTextField txtFactDocCliente;
    private javax.swing.JTextField txtFactNomCliente;
    private javax.swing.JTextField txtFactNomProducto;
    private javax.swing.JTextField txtPagoTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
