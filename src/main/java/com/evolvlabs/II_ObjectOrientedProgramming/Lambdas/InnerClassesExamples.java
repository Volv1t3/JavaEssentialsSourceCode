package com.evolvlabs.II_ObjectOrientedProgramming.Lambdas;

import com.evolvlabs.IV_Extras.Colorizer;

import java.math.BigInteger;

/**
 * <body style="color: white">El presente archivo contiene varios ejemplos de implementacion de clases cuyo cuerpo
 * contiene una o mas clases anonimas, todas estas con un poco de implementacion sencilla y con varios datos y metodos que
 * interactuan con sus clases externas.
 * <br><br>
 * La idea de este codigo es demostrar la facilidad de implementacion de un codigo basado en clases internas. Para esto
 * usaremos una estructura de clases relacionadas con el automovilismo </body>
 */
public class InnerClassesExamples {

    private static final Truck truckInstance = new Truck("Hino");
    public static void main(String[] args) {
        System.out.println(Colorizer.colorWithYellowLetters("Bienvenidos al programa demostrativo de clases internas en Java!"));
        System.out.println(Colorizer.colorWithCyanLetters("1. La instancia base de este programa cuenta con los siguientes datos"));
        System.out.println(truckInstance.toString());

        System.out.println(Colorizer.colorWithCyanLetters("2. Para analizar la forma de trabajar con clases internas, creemos una nueva" +
                " instancia"));
        Truck truckReference = new Truck("Mercedes-Benz");
        truckReference.setTruck_Make("Actros");
        truckReference.setTruck_MaxTonnelage(BigInteger.valueOf(18000));
        System.out.println(Colorizer.colorWithCyanLetters("2.1. La nueva instancia cuenta con los siguientes datos"));
        System.out.println(truckReference.toString());
        System.out.println(Colorizer.colorWithCyanLetters("3. Configuremos el motor de nuestras instancias"));
        /*! Inicializamos el motor de la instancia creada programaticamente*/
        truckReference.setTruck_EngineDefinition(400, "Diesel",25);
        /*! Inicializamos el motor de la instancia estatica*/
        truckInstance.setTruck_EngineDefinition(300, "Gasoline", 20);
        /*! Output de las instancias*/
        System.out.println(Colorizer.colorWithCyanLetters("3.1. La instancia programaticamente creada cuenta con los siguientes datos"));
        System.out.println(truckReference.toString());
        System.out.println(Colorizer.colorWithCyanLetters("3.2. La instancia estatica cuenta con los siguientes datos"));
        System.out.println(truckInstance.toString());
        /*! Inicializacion de la instancia interna de Wipers y creamos dos instancias externas adicionales*/
        System.out.println(Colorizer.colorWithCyanLetters("3.3. Configuremos el sistema de limpiabrazos de nuestras instancias"));
        truckReference.setTruck_WiperConfiguration(2, "Manual");
        truckInstance.setTruck_WiperConfiguration(2,"Automatic");
        /*! Output de las instancias*/
        System.out.println(Colorizer.colorWithCyanLetters("3.3. La instancia programaticamente creada cuenta con los siguientes datos"));
        System.out.println(truckReference.toString());
        System.out.println(Colorizer.colorWithCyanLetters("3.4. La instancia estatica cuenta con los siguientes datos"));
        System.out.println(truckInstance.toString());
        /*! Si la clase no es estatica: se tiene que usar una instancia de la clase base para instancia las clases internas*/
        Truck.Wipers wipersInstance = truckReference.new Wipers(20,"Automatic");
        /*! Si la clase es estatica: se tiene que usar una referencia a la clase base no una instancia*/
        Truck.AirFilter airFilterInstance = new Truck.AirFilter("Soaked","Large");

    }

    
}

/*! Clase secundario dentro del mismo archivo, su modificador de accesso se asume como privado*/
class Truck {
    /*! Parametros internos de la clase*/
    private String          truck_Brand;
    private String          truck_Make;
    private BigInteger      truck_MaxTonnelage;
    /*
     ? La clase externa puede tener una o mas instancias de la clase interna. La clase interna tiene accesso a todos
     ? los parametros externos y siempre esta sujeta a restricciones de los modificadores de accesso.
     */
    private Engine          truck_EngineDefinition;
    private Wipers          truck_WiperConfiguration;
    private WiperSystem     truck_WiperSystem;

    /*! Constructores*/
    public Truck(String truck_Brand){
        Truck.this.truck_Brand = truck_Brand;
    }

    /*! Setters y Getters*/
    public void setTruck_Brand(String Truck_Brand){
        if (truck_Brand == null){
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                    " Truck_Brand en el metodo setTruck_Brand fue nulo. ");
        }
        if (!Truck_Brand.isBlank()){
            Truck.this.truck_Brand = Truck_Brand;
        } else {
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                    " Truck_Brand en el metodo setTruck_Brand estaba vacio. ");
        }
        
    }
    public String getTruck_Brand() {
        return Truck.this.truck_Brand;
    }

    public void setTruck_Make(String Truck_Make){
        if (Truck_Make == null){
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                    " Truck_Make en el metodo setTruck_Make fue nulo. ");
        }
        if (!Truck_Make.isBlank()){
            Truck.this.truck_Make = Truck_Make;
        } else {
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                    " Truck_Make en el metodo setTruck_Make estaba vacio. ");
        }
    }
    public String getTruck_Make() {
        return Truck.this.truck_Make;
    }
    
    public void setTruck_MaxTonnelage(BigInteger Truck_MaxTonnelage){
        if (Truck_MaxTonnelage == null){
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                    " Truck_MaxTonnelage en el metodo setTruck_MaxTonnelage fue nulo. ");
        }
        if (Truck_MaxTonnelage.compareTo(BigInteger.ZERO) > 0){
            Truck.this.truck_MaxTonnelage = Truck_MaxTonnelage;
        } else {
            throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                    " Truck_MaxTonnelage en el metodo setTruck_MaxTonnelage estaba vacio. ");
        }
    }
    public BigInteger getTruck_MaxTonnelage() {
        return Truck.this.truck_MaxTonnelage;
    }

    /*! Metodo para crear una instancia de la clase interna Engine*/
    public void setTruck_EngineDefinition(int horsePower, String fuelType, int cylinderCount){
        Truck.this.truck_EngineDefinition = new Engine(horsePower, fuelType, cylinderCount);
    }
    /*! Por nomativa no dejamos salir a la clase privada de la clase externa. Protegemos los datos de la clase
      ! interna*/
    public String getTruck_EngineDefinition() {
        return Truck.this.truck_EngineDefinition.toString();
    }

    /*! Metodo para crear una instancia de la clase interna Wipers*/
    public void setTruck_WiperConfiguration(int wiperCount, String wiperType){
        Truck.this.truck_WiperConfiguration = new Wipers(wiperCount, wiperType);
        Truck.this.truck_WiperSystem = new WiperSystem(wiperCount, wiperType);
    }
    /*! Por nomativa no dejamos salir a la clase privada de la clase externa. Protegemos los datos de la clase
      ! interna*/
    public String getTruck_WiperConfiguration() {
        return Truck.this.truck_WiperConfiguration.toString();
    }

    /*! Implementacion basica de un toString*/
    @Override
    public String toString() {
        return "Truck{" +
                "truck_Brand='" + truck_Brand + '\'' + "\n" +
                ", truck_Make='" + truck_Make + '\'' + "\n" +
                ", truck_MaxTonnelage=" + truck_MaxTonnelage + "\n" +
                ", truck_EngineDefinition=" + ((this.truck_EngineDefinition != null) ? this.getTruck_EngineDefinition() : "undefined") + "\n" +
                ", truck_WiperConfiguration=" + ((this.truck_WiperConfiguration != null) ? this.getTruck_WiperConfiguration() : "undefined") + "\n" +
                '}';
    }
    
    /*?Clase Interna privada y final (no estatica) Motor*/
    private final class Engine{
        /*! Parametros de la clase interna Engine*/
        private int horsePower;
        private String fuelType;
        private int cylinderCount;

        /*! Constructores de la clase interna Engine*/
        public Engine(int horsePower, String fuelType, int cylinderCount){
            Engine.this.setHorsePower(horsePower);
            Engine.this.setFuelType(fuelType);
            Engine.this.setCylinderCount(cylinderCount);
        }

        /*! Setters y Getters */
        public void setHorsePower(int horsePower) {
            if (horsePower <= 0) {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " horsePower en el metodo setHorsePower era menor o igual a cero.");
            }
            this.horsePower = horsePower;
        }
        public int getHorsePower() {
            return this.horsePower;
        }
    
        public void setFuelType(String fuelType) {
            if (fuelType == null) {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " fuelType en el metodo setFuelType fue nulo.");
            }
            if (!fuelType.isBlank()) {
                this.fuelType = fuelType;
            } else {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " fuelType en el metodo setFuelType estaba vacio.");
            }
        }
        public String getFuelType() {
            return this.fuelType;
        }
    
        public void setCylinderCount(int cylinderCount) {
            if (cylinderCount <= 0) {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " cylinderCount en el metodo setCylinderCount era menor o igual a cero.");
            }
            this.cylinderCount = cylinderCount;
        }
        public int getCylinderCount() {
            return this.cylinderCount;
        }

        /*! Implementacion de toString() con los datos de toda la clase*/
        @Override
        public String toString() {
            return "Engine{" +
                    "horsePower=" + horsePower +
                    ", fuelType='" + fuelType + '\'' +
                    ", cylinderCount=" + cylinderCount +
                    '}';
        }
    }
    /*? Segunda clase Interna, publica, no final, no estatica*/
    public class Wipers{
        /*! Parametros de la clase interna Wipers*/
        private int wiperCount;
        private String wiperType;

        /*! Constructores de la clase interna Wipers*/
        public Wipers(int wiperCount, String wiperType){
            Wipers.this.setWiperCount(wiperCount);
            Wipers.this.setWiperType(wiperType);
        }

        /*! Setters y Getters*/
        public void setWiperCount(int wiperCount) {
            if (wiperCount <= 0) {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " wiperCount en el metodo setWiperCount era menor o igual a cero.");
            }
            this.wiperCount = wiperCount;
        }
        public int getWiperCount() {
            return this.wiperCount;
        }

        public void setWiperType(String wiperType) {
            if (wiperType == null) {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " wiperType en el metodo setWiperType fue nulo.");
            }
            if (!wiperType.isBlank()) {
                this.wiperType = wiperType;
            } else {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " wiperType en el metodo setWiperType estaba vacio.");
            }
        }
        public String getWiperType() {
            return this.wiperType;
        }

        /*! Implementacion de toString para la clase interna*/
        @Override
        public String toString() {
            return "Wipers{" +
                    "wiperCount=" + wiperCount +
                    ", wiperType='" + wiperType + '\'' +
                    '}';
        }
    }
    
    /*! Ejemplo de herencia dentro de una misma clase usando sus clases internas*/
    public class WiperSystem extends Wipers {

        public WiperSystem(int wiperCount, String wiperType) {
            super(wiperCount, wiperType);
        }
        
        public void activateWipers() {
            System.out.println("Activando los Limpia-parabrisas");
        }
    }

    public static final class AirFilter{
        /*! Parametros de la clase interna*/
        private String filterType;
        private String filterSize;

        /*! Constructores de la clase*/
        public AirFilter(String filterType, String filterSize) {
            this.filterType = filterType;
            this.filterSize = filterSize;
        }

        /*! Setters y Getters*/
        public void setFilterType(String filterType) {
            if (filterType == null) {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " filterType en el metodo setFilterType fue nulo.");
            }
            if (!filterType.isBlank()) {
                this.filterType = filterType;
            } else {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " filterType en el metodo setFilterType estaba vacio.");
            }
        }
        public String getFilterType() {
            return filterType;
        }

        public void setFilterSize(String filterSize) {
            if (filterSize == null) {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " filterSize en el metodo setFilterSize fue nulo.");
            }
            if (!filterSize.isBlank()) {
                this.filterSize = filterSize;
            } else {
                throw new IllegalArgumentException("Error: IllegalArgumentException thrown: El parametro " +
                        " filterSize en el metodo setFilterSize estaba vacio.");
            }
        }
        public String getFilterSize() {
            return filterSize;
        }
    }
}


