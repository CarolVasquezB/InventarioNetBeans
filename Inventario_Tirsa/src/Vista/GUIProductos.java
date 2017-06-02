/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlCategorias;
import Control.ControlProducto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1061792939
 */
public class GUIProductos extends javax.swing.JFrame {

    ControlProducto cp = new ControlProducto();
    ControlCategorias ca = new ControlCategorias();
    DefaultTableModel dtm;
    DefaultComboBoxModel cbx;

    String nombresColumnas[] = {"Codigo Producto", "Nombre", "Descripcion", "valor Compra", "valor VentaMax", "Sock", "Categoria",
        "valor VentaMin", "Fecha Compra"};

    /**
     *
     * Creates new form GUIProductos
     */
    public GUIProductos() {
        Object[][] data = cp.consultarProductos();
        Object[][] categorias = ca.consultarCategoria();

        int num_categorias = ca.contarCategorias();
        int i = 0;
        String aux[] = new String[num_categorias];

        while (i != num_categorias) {

            aux[i] = String.valueOf(categorias[i][0] + "-" + categorias[i][1]);

            i++;

        }
        cbx = new DefaultComboBoxModel(aux);
        dtm = new DefaultTableModel(data, nombresColumnas);
        initComponents();
        
    }

   

    public void actualizarTabla() {
        Object data[][] = cp.consultarProductos();
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblproductos.setModel(dtm);
        //validate();
        //repaint();
    }

    public void actualizarTabla(int codigo) {
        Object data[][] = cp.consultarproductoCodigo(codigo);
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblproductos.setModel(dtm);
        //validate();
        //repaint();
    }

    public void actualizarTabla(String letras) {
        Object data[][] = cp.consultarProductos(letras);
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblproductos.setModel(dtm);
            //validate();
        //repaint();
    }

    public void actualizarTabla_codigo(int numeros) {
        Object data[][] = cp.consultarProductos(numeros);
        dtm = new DefaultTableModel(data, nombresColumnas);
        tblproductos.setModel(dtm);
            //validate();
        //repaint();
    }

    public int Conseguir_cod_categoria() {
        int aux = cbxcategoria.getSelectedItem().toString().indexOf("-");
        Object data[][] = ca.consultarCategoriaNombre(cbxcategoria.getSelectedItem().toString().substring(aux + 1, cbxcategoria.getSelectedItem().toString().length()));;

        String cadena = String.valueOf(cbxcategoria.getSelectedItem().toString().substring(0, aux));
        int numero = Integer.parseInt(cadena);
        return numero;
    }

    public void limpiar() {
        txtcodproducto.setText("");
        txtnombreProducto.setText("");
        txtdescripcion.setText("");
        txtvalorCompra.setText("");
        txtfecha.setDate(null);
        txtvalorMax.setText("");
        txtvalorMin.setText("");
        txtstock.setText("");
        cbxcategoria.setSelectedIndex(0);
    }

    public boolean validar_ingreso_insercion() {
        boolean bandera = false;
        if (!txtcodproducto.getText().isEmpty() && !txtnombreProducto.getText().isEmpty() && !txtvalorCompra.getText().isEmpty() && !txtvalorMax.getText().isEmpty() && !txtstock.getText().isEmpty() && !txtvalorMin.getText().isEmpty()) {

            bandera = true;

        }
        return bandera;
    }

    public boolean validar_ingreso_consulta() {
        boolean bandera = false;
        if ((!txtnombreProducto.getText().isEmpty() && txtcodproducto.getText().isEmpty()) || (txtnombreProducto.getText().isEmpty() && !txtcodproducto.getText().isEmpty())) {
            bandera = true;
        }
        return bandera;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcodproducto = new javax.swing.JTextField();
        txtnombreProducto = new javax.swing.JTextField();
        txtvalorCompra = new javax.swing.JTextField();
        txtvalorMax = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        txtvalorMin = new javax.swing.JTextField();
        cbxcategoria = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextPane();
        btntodo = new javax.swing.JButton();
        txtfecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jscrollpanel = new javax.swing.JScrollPane();
        tblproductos = new javax.swing.JTable();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()), "Informacion del Producto", 0, 0, new java.awt.Font("Tempus Sans ITC", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Codigo Producto  (*)");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Nombre Producto (*)");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Descripcion");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Valor Compra (*)");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Valor Venta Maximo(*)");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("Stock Producto(*)");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText(" Categoria (*)");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Valor Venta minimo(*)");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Fecha Compra(*)");

        txtcodproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodproductoKeyReleased(evt);
            }
        });

        txtnombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreProductoKeyReleased(evt);
            }
        });

        cbxcategoria.setModel(cbx);
        cbxcategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGuardar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar5.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnactualizar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/db_update.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/erase.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnconsultar.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/address_book.png"))); // NOI18N
        btnconsultar.setText("Consultar");
        btnconsultar.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtdescripcion);

        btntodo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btntodo.setText("Ver Todo");
        btntodo.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btntodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtvalorMax, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtcodproducto)
                                        .addComponent(txtnombreProducto)
                                        .addComponent(txtvalorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtvalorMin, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxcategoria, 0, 193, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnconsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnactualizar))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btntodo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtcodproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtnombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(26, 26, 26)))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtvalorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtvalorMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtvalorMin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btntodo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Administracion de Productos");

        jscrollpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(0), "Registro de Productos", 0, 0, new java.awt.Font("Tempus Sans ITC", 1, 14))); // NOI18N
        jscrollpanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jscrollpanel.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        tblproductos.setModel(dtm);
        jscrollpanel.setViewportView(tblproductos);

        btnvolver.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/arrow_left.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.setBorder(new javax.swing.border.SoftBevelBorder(0));
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(156, 156, 156))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jscrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 747, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jscrollpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validar_ingreso_insercion()) {
            int cod_producto = Integer.parseInt(txtcodproducto.getText());
            String nombre_producto = txtnombreProducto.getText();
            String desc_producto = "";
            if (!txtdescripcion.getText().isEmpty()) {
                desc_producto = txtdescripcion.getText();
            }
            float valor_compra = Float.parseFloat(txtvalorCompra.getText());
            float valor_ventaMax = Float.parseFloat(txtvalorMax.getText());
            int stock = Integer.parseInt(txtstock.getText());
            float valor_ventamin = Float.parseFloat(txtvalorMin.getText());

            int codigocategoria = this.Conseguir_cod_categoria();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String fecha = "";
            if (txtfecha.getDate() != null) {
                fecha = dateFormat.format(txtfecha.getDate());
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese la fecha compra!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            boolean inserto = cp.insertarProducto(cod_producto, nombre_producto, desc_producto, valor_compra, valor_ventaMax, stock, codigocategoria, valor_ventamin, fecha);
            if (inserto) {
                JOptionPane.showMessageDialog(this, "Guardado Exitosamente!", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                actualizarTabla();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "El registro NO se ha guardado Corrrectamente\nRevise los datos Ingresados!", "Confirmacion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese los datos que son obligatorios (*)!", "Confirmacion", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        if (validar_ingreso_insercion()) {
            
            if (txtnombreProducto.getText().isEmpty() || txtcodproducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Consulta y luego actualiza los campos");
            } else {
                int cod_producto = Integer.parseInt(txtcodproducto.getText());
                String nombre_producto = txtnombreProducto.getText();
                String desc_producto = txtdescripcion.getText();
                float valor_compra = Float.parseFloat(txtvalorCompra.getText());
                float valor_ventaMax = Float.parseFloat(txtvalorMax.getText());
                int stock = Integer.parseInt(txtstock.getText());
                float valor_ventamin = Float.parseFloat(txtvalorMin.getText());

                int codigocategoria = this.Conseguir_cod_categoria();

                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String fecha = "";

                if (txtfecha.getDate() != null) {
                    fecha = dateFormat.format(txtfecha.getDate());
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese la fecha compra!", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                boolean actualizo = cp.actualizarProducto(cod_producto, nombre_producto, desc_producto, valor_compra, valor_ventaMax, stock, codigocategoria, valor_ventamin, fecha);
                if (actualizo) {
                    JOptionPane.showMessageDialog(this, "Se ha actualizado Exitosamente!", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                    actualizarTabla();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "El registro NO se actualizo Corrrectamente\nRevise los datos Ingresados!", "Confirmacion", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Consulta primero la informacion ingresando el codigo del producto!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        if (validar_ingreso_consulta()) {
            Object data[][];

            if (!txtnombreProducto.getText().isEmpty() && txtcodproducto.getText().isEmpty()) {
                data = cp.consultarproductoXNombre(txtnombreProducto.getText());
            } else {
                data = cp.consultarproductoCodigo(Integer.parseInt(txtcodproducto.getText()));
            }
            if (data[0][0] != null) {
                txtcodproducto.setText(data[0][0].toString());
                txtnombreProducto.setText(data[0][1].toString());
                txtdescripcion.setText(data[0][2].toString());
                txtvalorCompra.setText(data[0][3].toString());
                txtvalorMax.setText(data[0][4].toString());
                txtstock.setText(data[0][5].toString());
               
                
                Object data_consulta[][] = ca.consultarCategoriaCodigo(Integer.parseInt(String.valueOf(data[0][6].toString())));
                cbxcategoria.setSelectedItem(data_consulta[0][0].toString() + "-" + data_consulta[0][1].toString());
                txtvalorMin.setText(data[0][7].toString());

            } else {
                JOptionPane.showMessageDialog(this, "No se Encontraron registros!", "Confirmacion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese el codigo o nombre del Producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (validar_ingreso_consulta()) {

            if (!txtnombreProducto.getText().isEmpty() && txtcodproducto.getText().isEmpty()) {
                if (cp.eliminarproductoxNombre(txtnombreProducto.getText())) {
                    actualizarTabla();

                    int res = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar el registro del producto: " + txtnombreProducto.getText(), "Confirmacion", JOptionPane.WARNING_MESSAGE);
                    if (res == JOptionPane.YES_OPTION) {

                        JOptionPane.showMessageDialog(this, "Eliminado!", "confirmacion!", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "NO se encontro el registro!", "confirmacion!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (cp.eliminarProducto(Integer.parseInt(txtcodproducto.getText()))) {
                int res = JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar el registro del producto: " + txtcodproducto.getText(), "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                if (res == JOptionPane.YES_OPTION) {

                }

            } else {
                JOptionPane.showMessageDialog(this, "NO se encontro el registro!", "confirmacion!", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar el Nombre o Codigo del producto", "Advertencia!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtnombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreProductoKeyReleased
        String letra = txtnombreProducto.getText();
        actualizarTabla(letra);
    }//GEN-LAST:event_txtnombreProductoKeyReleased

    private void txtcodproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodproductoKeyReleased
        int numero = Integer.parseInt(txtcodproducto.getText());
        actualizarTabla_codigo(numero);
    }//GEN-LAST:event_txtcodproductoKeyReleased

    private void btntodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntodoActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btntodoActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
       GUIPrincipal gpr=new GUIPrincipal();
       this.setVisible(false);
       gpr.setVisible(true);
    }//GEN-LAST:event_btnvolverActionPerformed

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
            java.util.logging.Logger.getLogger(GUIProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btntodo;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox cbxcategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jscrollpanel;
    private javax.swing.JTable tblproductos;
    private javax.swing.JTextField txtcodproducto;
    private javax.swing.JTextPane txtdescripcion;
    private com.toedter.calendar.JDateChooser txtfecha;
    private javax.swing.JTextField txtnombreProducto;
    private javax.swing.JTextField txtstock;
    private javax.swing.JTextField txtvalorCompra;
    private javax.swing.JTextField txtvalorMax;
    private javax.swing.JTextField txtvalorMin;
    // End of variables declaration//GEN-END:variables
}
