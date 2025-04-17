package com.fmt.Umd.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SabModuleAction")
public class SabModuleAction {

	    @Id
	    @Column(name="action_id")
		@GeneratedValue(strategy = GenerationType.AUTO)

		private Integer actionID;
	    @Column
	    private String moduleID;
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="action_id_submodule_id")
	    private SubModule sabmodule;
	    @Column(name="addition")
	    private String add;
	    @Column(name="edit")
	    private String edit;
	    @Column(name="deletion")
	    private String delete;
	    @Column(name="view")
	    private String view;

		public String getModuleID() {
			return moduleID;
		}
		public void setModuleID(String moduleID) {
			this.moduleID = moduleID;
		}
		public Integer getActionID() {
			return actionID;
		}
		public void setActionID(Integer actionID) {
			this.actionID = actionID;
		}

		public SubModule getSabmodule() {
			return sabmodule;
		}
		public void setSabmodule(SubModule sabmodule) {
			this.sabmodule = sabmodule;
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
