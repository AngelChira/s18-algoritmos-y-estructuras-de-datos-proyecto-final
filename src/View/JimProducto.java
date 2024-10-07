package View;

import daoImpl.CategoriaDaoImpl;
import daoImpl.ProductoDaoImpl;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Producto;

public class JimProducto extends javax.swing.JInternalFrame {

    private ProductoDaoImpl crudProducto;
    private DefaultTableModel modelo;
    private CategoriaDaoImpl IDaoCategoria = new CategoriaDaoImpl();
    private Object[] filaDatos;
    private int idProducto;
    private boolean guardar = false;

    public JimProducto() {
        initComponents();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(ancho, alto - 106);
        filaDatos = new Object[4];
        crudProducto = new ProductoDaoImpl();
        modelo = new DefaultTableModel();
        cargarCategorias();
        listarProductos();
        habilitarCampo(false);
        registroBotones(false);
        crudBotones(false);
    }

    private void cargarCategorias() {
//        cboCategoria.addItem("Seleccionar");
//        System.out.println("aaaaaaaaaaa");
//        for (Categoria ca : IDaoCategoria.listar()) {
//            if (ca != null) {
//                cboCategoria.addItem(ca.getNombre());
//                System.out.println(""+ca.getNombre());
//            }
//        }
// Limpiar el JComboBox antes de agregar nuevos elementos
        cboCategoria.removeAllItems();

        // Agregar la opci�n por defecto
        cboCategoria.addItem("Seleccionar");

        // Verificar que IDaoCategoria no sea nulo y listar las categor�as
        if (IDaoCategoria != null) {
            for (Categoria ca : IDaoCategoria.listar()) {
                if (ca != null) {
                    cboCategoria.addItem(ca.getNombre());
                    System.out.println(ca.getNombre());
                }
            }
        } else {
            System.out.println("IDaoCategoria es nulo.");
        }
    }

    private void limpiarTabla() {
        modelo = (DefaultTableModel) tblProducto.getModel();
        modelo.getDataVector().removeAllElements();
        tblProducto.removeAll();
    }

    private void listarProductos() {
        modelo = (DefaultTableModel) tblProducto.getModel();
//        for (Producto p : crudProducto.listar()) {
//            filaDatos[0] = p.getIdProducto();
//            filaDatos[1] = iDaoCategoria.obtenerNombre(p.getIdCategoria());
//            filaDatos[2] = p.getNombre();
//            filaDatos[3] = p.getDescripcion();
//            modelo.addRow(filaDatos);
//        }
        if (crudProducto.total() > 1) {
            buscarCampo(true);
        } else {
            buscarCampo(false);
        }
    }

    private void registroBotones(boolean f) {
        btnGuardar.setEnabled(f);
        btnCancelar.setEnabled(f);
    }

    private void crudBotones(boolean f) {
        btnNuevo.setEnabled(!f);
        btnEditar.setEnabled(f);
        btnEliminar.setEnabled(f);
    }

    private void habilitarCampo(boolean f) {
        cboCategoria.setEnabled(f);
        txtNombre.setEnabled(f);
        taDescripcion.setEnabled(f);
    }

    private void limpiarCampos() {
        cboCategoria.setSelectedIndex(0);
        txtNombre.setText("");
        taDescripcion.setText("");
    }

    private void buscarCampo(boolean f) {
        txtBuscar.setText("");
        txtBuscar.setEnabled(f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        cboCategoria = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        lblMensaje = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setText("Productos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Categor�a:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Nombre del Producto:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Buscar:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 350, 30));

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categor�a", "Nombre", "Descripcion"
            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProductoMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblProducto);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 1090, 210));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Descripci�n:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, 30));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, 30));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 90, 30));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, 90, 32));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, 90, 33));

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 90, 30));

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("Guardar");
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 580, 90, -1));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("Cancelar");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 580, -1, -1));

        cboCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(cboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 290, 30));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 290, 30));

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        jScrollPane1.setViewportView(taDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 280, 100));

        lblMensaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 420, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String title = txtNombre.getText().strip();
        String descripcion = taDescripcion.getText().strip();
        if (!title.isEmpty()) {
            if (title.length() > 50) {
                JOptionPane.showMessageDialog(null,
                        "Advertencia, El nombre del producto es muy largo.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                txtNombre.requestFocus();
                return;
            }
            if (cboCategoria.getSelectedItem().equals("Seleccionar")) {
                JOptionPane.showMessageDialog(null,
                        "Advertencia, Debe seleccionar una categoria.",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                cboCategoria.requestFocus();
                return;
            }
            int idCategoria = IDaoCategoria.obtenerId(cboCategoria.getSelectedItem().toString());
            if (guardar) {
                if (crudProducto.actualizar(new Producto(idProducto, title, descripcion, idCategoria))) {
                    lblMensaje.setText("Se actualizo correctamente el producto con id " + idProducto + ".");
                    limpiarCampos();
                    habilitarCampo(false);
                    registroBotones(false);
                    crudBotones(false);
                    guardar = false;
                } else {
                    lblMensaje.setText("No se actualizo el producto.");
                }
            } else {
                if (crudProducto.agregar(new Producto(title, descripcion, idCategoria))) {
                    lblMensaje.setText("Se agrego correctamente el producto.");
                    limpiarCampos();
                    habilitarCampo(false);
                    registroBotones(false);
                    crudBotones(false);
                } else {
                    lblMensaje.setText("No se agrego el producto.");
                }
            }
            tblProducto.clearSelection();
            limpiarTabla();
            listarProductos();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Advertencia, Ingresar el nombre del producto",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblProducto.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Desea eliminar el registro", "Eliminar", JOptionPane.YES_NO_OPTION, 3) == 0) {
                if (crudProducto.eliminar(new Producto(idProducto))) {
                    lblMensaje.setText("El registro se elimin� correctamente");
                } else {
                    lblMensaje.setText("El registro NO se pudo eliminar");
                }
            }
            buscarCampo(true);
            limpiarTabla();
            listarProductos();
            limpiarCampos();
            registroBotones(false);
            crudBotones(false);
            txtNombre.setText("");
            tblProducto.clearSelection();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitarCampo(true);
        limpiarCampos();
        registroBotones(true);
        crudBotones(false);
        limpiarTabla();
        listarProductos();
        buscarCampo(false);
        btnNuevo.setEnabled(false);
        lblMensaje.setText("");
        tblProducto.clearSelection();
        cboCategoria.requestFocus();
        guardar = false;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCampos();
        limpiarTabla();
        listarProductos();
        habilitarCampo(false);
        crudBotones(false);
        registroBotones(false);
        lblMensaje.setText("");
        tblProducto.clearSelection();
        guardar = false;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblProductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseReleased
        int fila = tblProducto.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            habilitarCampo(false);
            idProducto = Integer.parseInt(tblProducto.getValueAt(fila, 0).toString());
            cboCategoria.setSelectedItem(tblProducto.getValueAt(fila, 1));
            txtNombre.setText(tblProducto.getValueAt(fila, 2).toString());
            taDescripcion.setText(tblProducto.getValueAt(fila, 3).toString());
            lblMensaje.setText("");
            buscarCampo(false);
            registroBotones(false);
            crudBotones(true);
            btnCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_tblProductoMouseReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        guardar = true;
        habilitarCampo(true);
        registroBotones(true);
        crudBotones(false);
        limpiarTabla();
        listarProductos();
        buscarCampo(false);
        btnNuevo.setEnabled(false);
        lblMensaje.setText("");
        tblProducto.clearSelection();
        cboCategoria.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        limpiarTabla();
        int n = 0;
        modelo = (DefaultTableModel) tblProducto.getModel();
        String valorBuscar = txtBuscar.getText().strip();
        if (valorBuscar.equalsIgnoreCase("")) {
            limpiarTabla();
            listarProductos();
            lblMensaje.setText("");
        } else {
//            for (Producto pr : crudProducto.listar(valorBuscar)) {
//                filaDatos[0] = pr.getIdProducto();
//                filaDatos[1] = iDaoCategoria.obtenerNombre(pr.getIdCategoria());
//                filaDatos[2] = pr.getNombre();
//                filaDatos[3] = pr.getDescripcion();
//                modelo.addRow(filaDatos);
//                n++;
//            }
            lblMensaje.setText(n + " registros encontrados.");
        }
        txtNombre.setText("");
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextArea taDescripcion;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
