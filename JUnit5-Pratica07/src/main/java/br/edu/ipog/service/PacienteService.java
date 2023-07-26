package br.edu.ipog.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ipog.model.Paciente;

public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente buscarPacientePorId(long id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    public void atualizarPaciente(Paciente paciente) {
        Paciente pacienteExistente = buscarPacientePorId(paciente.getId());
        if (pacienteExistente != null) {
            pacienteExistente.setNome(paciente.getNome());
            pacienteExistente.setIdade(paciente.getIdade());
        }
    }

    public void excluirPaciente(long id) {
        Paciente pacienteExistente = buscarPacientePorId(id);
        if (pacienteExistente != null) {
            pacientes.remove(pacienteExistente);
        }
    }
}

