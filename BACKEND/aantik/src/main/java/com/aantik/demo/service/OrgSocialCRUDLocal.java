package com.aantik.demo.service;

import com.aantik.demo.entidad.OrgSocial;
import com.aantik.demo.model.ModOrgSocial;

public interface OrgSocialCRUDLocal {
	public OrgSocial crearOrganizacion(OrgSocial org) throws Exception;
	public Iterable<OrgSocial> getAll();
	public void saveAll(ModOrgSocial[] orgLista);
}
