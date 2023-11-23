package com.rmc.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmc.app.domain.Movimiento;

@Service

public class MovimientoServiceImp implements MovimientoService{
    @Autowired 
    public CuentaService cuentaService;
    private List<Movimiento> listaMovimiento = new ArrayList<>();

    public Movimiento añadir(Movimiento movimiento) {
        movimiento.setData(LocalDateTime.now());
        listaMovimiento.add(movimiento);
        cuentaService.actualizarSaldo(movimiento);
        return movimiento; // podría no devolver nada, o boolean, etc.
    }
    public List<Movimiento> obteberLista() {
        return listaMovimiento;
    }
    public Movimiento obtenerPorIBAN(String IBAN) {
        for (Movimiento movimeinto : listaMovimiento)
            if (movimeinto.getIBAN().equals(IBAN))
                return movimeinto;
        return null; // debería lanzar excepción si no encontrado
    }
    public Movimiento editar(Movimiento movimiento) {
        int pos = listaMovimiento.indexOf(movimiento);
        if (pos == -1)
            return null; // debería lanzar excepción si no encontrado
        listaMovimiento.set(pos, movimiento); // si lo encuentra, lo sustituye
        return movimiento;
    }
    public void borrar(String IBAN) {
        Movimiento movimiento = this.obtenerPorIBAN(IBAN);
        if (movimiento != null) {
            listaMovimiento.remove(movimiento); // podría devolver boolean
        }
    }
    public List<Movimiento> findByCuenta(String IBAN){
        List<Movimiento> listaMovCuenta = new ArrayList<>();
        for (Movimiento movimeinto : listaMovimiento){
            if (movimeinto.getIBAN() == IBAN)
                listaMovCuenta.add(movimeinto);
        }
        return listaMovCuenta;
    }


}
