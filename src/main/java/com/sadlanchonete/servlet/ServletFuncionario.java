package com.sadlanchonete.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sadlanchonete.daos.FuncionarioDao;
import com.sadlanchonete.entidade.Endereco;
import com.sadlanchonete.entidade.Funcionario;
import com.sadlanchonete.entidade.Telefone;
import com.sadlanchonete.helpers.ConversoesHelper;

@WebServlet("/ServletFuncionario")
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
        if(br != null){
            json = br.readLine();
        }
        
        Funcionario funcionario = new Funcionario();
        
        Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        funcionario = gson.fromJson(json, Funcionario.class);
        
        for(Telefone telefone : funcionario.getTelefones()){
            telefone.setFuncionario(funcionario);
        }
        
        for(Endereco endereco : funcionario.getEnderecos()){
        	endereco.setFuncionario(funcionario);
        }
        
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.add(funcionario);
	}

}
