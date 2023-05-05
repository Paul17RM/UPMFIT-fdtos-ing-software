package upm.etsisi;

import java.sql.Date;

public class Cuota {

	private Date fecha;
	private float importe;

	public Cuota(Date fecha, float importe) {
		this.fecha = fecha;
		this.importe = importe;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getImporte() {
		return this.importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
}