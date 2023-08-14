package FabricaTematica;

import Entidades.*;

public interface FabricaTematicasAbstracta {
	
	public EnemigoBlinky crearEnemigoBlinky(int posX,int posY);
	public EnemigoClyde crearEnemigoClyde(int posX,int posY);
	public EnemigoInky crearEnemigoInky(int posX,int posY, EnemigoBlinky blinky);
	public EnemigoPinky crearEnemigoPinky(int posX,int posY);
	public PersonajePrincipal crearPersonajePrincipal(int posX,int posY);
	public Pared crearParedNivel1(int posX,int posY);
	public Pared crearParedNivel2(int posX,int posY);
	public Pared crearParedNivel3(int posX,int posY);
	public Fruta crearFruta(int posX,int posY);
	public PacDots crearPacDots(int posX,int posY);
	public PowerPellets crearPowerPellets(int posX,int posY);
	public PocionVelocidad crearPocionVelocidad(int posX,int posY);
	public PocionBombas crearPocionBombas(int posX,int posY);
	public Explosion crearExplosion(int posX,int posY);
	public String musicaNivel(int lvl);
}
