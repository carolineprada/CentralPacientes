/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.security.Principal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el método que agrega al principio
        //CPRADA
        /**
         * Se adiciona la nueva entrada al inicio de la lista, para ello se utiliza la posición 0
         */
        pacientes.add(0, pac);
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        //CPRADA
        /**
         * Teniendo en cuenta que siempre que se utiliza app el registro del Arraylist
         * se adicional después, no fue necesario adicionar posición
         */
        pacientes.add(pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente antes del paciente con el código dado
        //CPRADA
        /**
         * Para poder posicionar el paciente nuevo antes del código del paciente ingresado por parámetro
         * se debe tener en cuenta la posición de este, es por ello que primero se buscó la posición del
         * paciente ingresado y ya con ello se pudo adicionar el nuevo paciente
         */
        int pos = 0;
        //Se busca la posición del código a buscar
        for (int i = 0; i < pacientes.size(); i++){

            if (pacientes.get(i).darCodigo() == cod) {
                pos = i;
            }
        }
        pacientes.add(pos, pac);
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
        //CPRADA
        /**
         * Al igual que el caso anterior, se debe tener en cuenta primero hallar
         * la posición del código del paciente ingresado para así poder adicionar el nuevo paciente
         * para ello fue necesario a la posición encontrada, adiciona 1
         */
        int pos = 0;
        //Se busca la posición del código a buscar
        for (int i = 0; i < pacientes.size(); i++){

            if (pacientes.get(i).darCodigo() == cod) {
                pos = i+1;
            }
        }
        pacientes.add(pos, pac);

    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        //CPRADA
        /**
         * Para localizar el paciente, primero se debe hallar la posición de
         * este y seguido de ello retornar los datos de acuerdo a la posición en
         * el ArrayList
         */
        int pos = 0;

        Paciente pac;
        //Se busca la posición del código a buscar
        for (int i = 0; i < pacientes.size(); i++){

            if (pacientes.get(i).darCodigo() == codigo) {
                pos = i;
                return pacientes.get(pos);
            }
        }
        return null;
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción
        //CPRADA
        /**
         * Para eliminar un registro, primero se debe hallar la posición del paciente
         * ingresado por parámetro y seguido de ello si proceder con su eliminación
         */
        int pos = 0;
        //Se busca la posición del código a buscar
        for (int i = 0; i < pacientes.size(); i++){

            if (pacientes.get(i).darCodigo() == cod) {
                pos = i;
            }
        }
        pacientes.remove(pos);

    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        //CPRADA
        /**
         * Relizar un conteo de la cantidad de hombres que se encuentren
         * dentro del Arraylist, teniendo en cuenta que el género de los hombres está
         * dado por el número 1
         */
        int pos = 0;
        int cont = 0;
        //Se busca la posición del código a buscar
        for (int i = 0; i < pacientes.size(); i++){

            if (pacientes.get(i).darSexo() == 1) {
                cont++;
            }
        }return cont;


    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        //CPRADA
        /**
         * Relizar un conteo de la cantidad de mujeres que se encuentren
         * dentro del Arraylist, teniendo en cuenta que el género de las mujeres está
         * dado por el número 2
         */
        int pos = 0;
        int cont = 0;
        //Se busca la posición del código a buscar
        for (int i = 0; i < pacientes.size(); i++){

            if (pacientes.get(i).darSexo() == 2) {
                cont++;
            }
        }return cont;

    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        //CPRADA
        /**
         * Este método cuenta con 3 for los cuales fueron necesarios
         * para poder encontrar la clínica que cuenta con más ocupación
         */

        //Se declara un ArrayList el cual almacenará las clínicas capturadas en el
        //ArrayList de los paciente
        ArrayList<String> clinica = new ArrayList<>();


        //Se ingresan las clínicas en un ArrayList, en este paso se encuentra
        //todas las clínicas, de los diferentes registros, se pueden
        //presentar duplicidad (Está bien para poder continuar en la línea 286)
        for (int i = 0; i < pacientes.size(); i++) {
            clinica.add(pacientes.get(i).darClinica());
        }

        //Se generan 2 ArrayList uno que contendrá el nombre de la clínica (obj) y
        //otro que contará con la cantidad de veces que la clínica se encuentra en
        //los diferentes registros de paciente (cant)
        ArrayList<String> obj = new ArrayList<>();
        ArrayList<Integer> cant = new ArrayList<>();

        //En este for se valida la cantidad de veces que se encuentra una clínica dentro de un ArrayList
        //y la el nombre de la clínica y estos se almacenan en los ArrayList creado en la línea 290-291
        Set<String> valid = new HashSet<>(clinica); //Distinct
        for (String s: valid){
                //Se ingresa el valor de la clínica y la cantidad
                obj.add(s);
                cant.add((Collections.frequency(clinica, s)));
        }


        //Finalmente y con ayuda de un ciclo for, se determina cual de las
        //clínicas cuenta con mayor ocupación
        int max = 1;
        int n = cant.size();
        String val = null;
        for (int i =0; i < n; i++){
            if (cant.get(i) > max){
                max =cant.get(i);
                val = obj.get(i);
            }
        }
        return val;
    }


}


