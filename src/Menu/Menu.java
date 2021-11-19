package Menu;

public class Menu {
    public static void mainMenu() {
        System.out.println("""
                Menu principal
                1- Ejecutar consulta
                2- Ejecutar DML
                3- Ejecutar DDl
                4- Configurar conexion
                5- Salir
                """);
    }
    public static void configMenu() {
        System.out.println("""
                Menu de confguracion
                1- Cambiar usuario
                2- Cambiar contraseña
                3- Cambiar BBDD
                4- Cambiar Puerto
                5- Cambiar Host
                6- Salir
                """);
    }
    public static void askUser()
    {
        System.out.println("Introduzca el nuevo usuario:");
    }
    public static void askPassword()
    {
        System.out.println("Introduzca la nueva contraseña:");
    }
    public static void askDB()
    {
        System.out.println("Introduzca la nueva BBDD:");
    }
    public static void askPort()
    {
        System.out.println("Introduzca el nuevo puerto:");
    }
    public static void askHost()
    {
        System.out.println("Introduzca el nuevo host:");
    }
    public static void askQuery(){
        System.out.println("Introduzca la consulta que desea realizar");
    }
    public static void askSqlSentence(){
        System.out.println("Introduzca la sentencia SQL que desea realizar");
    }
}
