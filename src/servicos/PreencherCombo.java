package servicos;

import beans.Agenda_Central;
import beans.Item_Agendamento;
import beans.Servico_Disc;
import beans.Tipo_Marc;
import java.util.List;
import javax.swing.JComboBox;
import model.DAO.Agenda_Central_DAO;




public class PreencherCombo {
    //metodo para preecher o combobos da zona
    public static void preencherComboTipoMarc(JComboBox combo, int codigo){
        combo.removeAllItems();
        Agenda_Central_DAO ad = new Agenda_Central_DAO();
        List<Tipo_Marc> lista =ad.tipo_Marc(codigo);
        lista.stream().forEach((ac) -> {
            combo.addItem(ac);
        }); 
    }//fim do metod que preeche o combo da zona
    
    //metodo para preecher o combobos da zona
    public static void preencherComboServico(JComboBox combo, int codigo){
        combo.removeAllItems();
        Agenda_Central_DAO ad = new Agenda_Central_DAO();
        List<Servico_Disc> lista =ad.lista_servico(codigo);
        
        lista.stream().forEach((ac) -> {
            
            combo.addItem(ac);
        }); 
    }//fim do metod que preeche o combo da zona
   
    public static void preencherComboTipo(JComboBox combo, int codigo){
        combo.removeAllItems();
        Agenda_Central_DAO ad = new Agenda_Central_DAO();
        List<Item_Agendamento> list = ad.lista_item(codigo);
        
        list.stream().forEach((ac) -> {
            
            combo.addItem(ac);
        }); 
    }
    }//fim remover linha    
        
    //metodo para preecher o combobox com os estado civil do cliente
    /*
        public static void preencherComboEstadoCivil(){
        EstadoCivilDao estadoCivilDao = new EstadoCivilDao();
        List<EstadoCivil> lista = estadoCivilDao.listarTodosEstadoCivil();
        for(EstadoCivil estadoCivil:lista){
           TelaCadCliente.jCestadoCivil.addItem(estadoCivil);
        } 
    }//fim do metodo que preenche o combox com o estado civil
    //metodo para preecher o combobox com os estado civil do cliente
    public static void preencherComboEstadoEmissor(){
        EstadoEmissorDao estadoEmissorDao = new EstadoEmissorDao();
        List<EstadoEmissor> lista = estadoEmissorDao.listarTodosEstadoEmissor();
        for(EstadoEmissor estadoEmissor:lista){
           TelaCadCliente.jCestadoEmissor.addItem(estadoEmissor);
        } 
    }//fim do metodo que preenche o combox com o estado civil

    //metodo para preecher o combobox com os estado civil do cliente
    public static void preencherComboBairro(){
        BairroDao bairroDao = new BairroDao();
        List<Bairro> lista = bairroDao.listarTodosBairros();
        for(Bairro bairro:lista){
           TelaCadCliente.jCbairro.addItem(bairro);
        } 
    }
        
        */
        //fim do metodo que preenche o combox com o estado civil

    

        
        
        
        
        
        
    









