package com.certification.bunasolappBackEnd.metier;

import java.util.List;
import java.util.Optional;

import com.certification.bunasolappBackEnd.entity.Agent;

public interface AgentMetier {

	List<Agent> getListAgents();

	Optional<Agent> getAgentById(Long id);

	Agent createAgent(Agent agent);

	Agent updateAgent(Long id, Agent agent);

	Agent updatePasswordAgent(Long id, String new_password);

	Agent updateRoleAgent(Long id, String new_role);

	void deleteAgent(Long id);

}
