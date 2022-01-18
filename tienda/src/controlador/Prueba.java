
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.CajeroVentasDAO;
import modelo.dto.CajeroVentasDTO;

/**
 *
 * @author Angel
 */
public class Prueba {
    public static void main(String[] args) {
        CajeroVentasDAO caj=new CajeroVentasDAO();
//      prov.create(new ProveedorDTO(1071818412,"asdasd","asdasd",974579684,"adasd","sdasd","asdasd","asdasd"));
//        List<ProveedorDTO> proveedores=new ArrayList();
//        proveedores=prov.readAll();
//       System.out.print(provbus.getDistrito());
//      for(ProveedorDTO proved:proveedores){
//        System.out.println(proved.getRUC()+","+proved.getDireccion());
//      }
//          prov.delete(1071818411);
        
       //caj.create(new CajeroVentasDTO(4,"2022-01-17",600));
        //caj.delete(1);
        CajeroVentasDTO cajdat=caj.read(2);
       // System.out.println(cajdat.getFecha_venta());
        List<CajeroVentasDTO> lista= caj.readAll();
        for(CajeroVentasDTO proved:lista){
           System.out.println(proved.getFecha_venta()+","+proved.getMonto());
      }
    }
}
