package com.aantik.demo.service;

import com.aantik.demo.entidad.Benchmarking;

public interface BenchmarkingCRUDLocal {
	public Benchmarking crearBenchmarking(Benchmarking bench) throws Exception;
	public Iterable<Benchmarking> getAll();
}
