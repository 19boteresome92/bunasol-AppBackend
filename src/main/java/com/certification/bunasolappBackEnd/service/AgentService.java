package com.certification.bunasolappBackEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certification.bunasolappBackEnd.entity.Agent;
import com.certification.bunasolappBackEnd.metier.AgentMetier;
import com.certification.bunasolappBackEnd.repository.AgentRepository;

@Service
public class AgentService implements AgentMetier {

	@Autowired
	private AgentRepository agentRepository;

	@Override
	public List<Agent> getListAgents() {

		return agentRepository.findAll();
	}

	@Override
	public Optional<Agent> getAgentById(Long id) {
		if (id == null) {
			// Gérer le cas où l'ID est null
			return Optional.empty();
		}
		return agentRepository.findById(id);
	}

	@Override
	public Agent createAgent(Agent new_agent) {
		if (new_agent == null) {
			// Gérer le cas où l'ID est null
			return null;
		}
		return agentRepository.save(new_agent);
	}

	@Override
	public Agent updateAgent(Long id, Agent agent) {
		@SuppressWarnings("null")
		Agent existingAgent = agentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Agent non trouvé avec id: " + id));
		existingAgent.setFonction(agent.getFonction());
		existingAgent.setNom(agent.getNom());
		existingAgent.setPrenom(agent.getPrenom());
		existingAgent.setTitre_honorifique(agent.getTitre_honorifique());
		return agentRepository.save(existingAgent);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteAgent(Long id) {
		Agent existingAgent = agentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Agent non trouvé avec id: " + id));
		agentRepository.delete(existingAgent);
	}

	@Override
	public Agent updatePasswordAgent(Long id, String new_password) {
		@SuppressWarnings("null")
		Agent existingAgent = agentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Agent non trouvé avec id: " + id));
		existingAgent.setMotDePasse(new_password);
		return agentRepository.save(existingAgent);
	}

	@Override
	public Agent updateRoleAgent(Long id, String role) {
		@SuppressWarnings("null")
		Agent existingAgent = agentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Agent non trouvé avec id: " + id));
		existingAgent.setRole(role);
		return agentRepository.save(existingAgent);
	}
}
