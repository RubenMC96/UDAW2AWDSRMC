package com.rmc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmc.app.domain.Cuenta;
import com.rmc.app.domain.Movimiento;

@Service
public class CuentaServiceImp implements CuentaService{
    private List<Cuenta> listaProductos = new ArrayList<>();
    

    public Cuenta añadir(Cuenta cuenta) {
        cuenta.setSaldo(0f);
        listaProductos.add(cuenta);
        return cuenta; // podría no devolver nada, o boolean, etc.
    }
    public List<Cuenta> obteberLista() {
        return listaProductos;
    }
    public Cuenta obtenerPorIBAN(String IBAN) {
        for (Cuenta producto : listaProductos)
            if (producto.getIBAN().equals(IBAN)){
                return producto;
            }
                
        return null; // debería lanzar excepción si no encontrado
    }
    public Cuenta editar(Cuenta producto) {
        int pos = listaProductos.indexOf(producto);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        listaProductos.set(pos, producto); // si lo encuentra, lo sustituye
        return producto;
    }
    public void borrar(String IBAN) {
        Cuenta producto = this.obtenerPorIBAN(IBAN);
        if (producto != null) {
            listaProductos.remove(producto); // podría devolver boolean
        }
    }

        public void actualizarSaldo(Movimiento movimiento){
            Float mov;
            String IBANMov = movimiento.getIBAN();

            System.out.println("IBANMov" + IBANMov);
            Cuenta cuenta = obtenerPorIBAN(IBANMov);
            System.out.println("ListaCuentas" + listaProductos);

            mov = cuenta.getSaldo() + movimiento.getImporte();
            cuenta.setSaldo(mov);
        }

    
}
