package com.fmt.Umd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="moduleAction")
public class ModuleAction {

	    @Id
	    @Column(name="action_id")
		private Integer actionID;
	    @OneToOne
	    @JoinColumn(name="action_id_module_id")
	    private Module module;
	    @Column(name="addition")
	    private String add;
	    @Column(name="edit")
	    private String edit;
	    @Column(name="deletion")
	    private String delete;
	    @Column(name="view")
	    private String view;
		public Integer getActionID() {
			return actionID;
		}
		public void setActionID(Integer actionID) {
			this.actionID = actionID;
		}
		public Module getModule() {
			return module;
		}
		public void setModule(Module module) {
			this.module = module;
		}
		public String getAdd() {
			return add;
		}
		public void setAdd(String add) {
			this.add = add;
		}
		public String getEdit() {
			return edit;
		}
		public void setEdit(String edit) {
			this.edit = edit;
		}
		public String getDelete() {
			return delete;
		}
		public void setDelete(String delete) {
			this.delete = delete;
		}
		public String getView() {
			return view;
		}
		public void setView(String view) {
			this.view = view;
		}
		
		
	    
	    
}
